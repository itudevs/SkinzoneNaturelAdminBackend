package com.skinzoneadmin.skinzonenaturel.Firebase;

import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import com.skinzoneadmin.skinzonenaturel.Entities.User;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;

/**
 * Filters Every Http Request if Authenticated
 */
public class FirebaseAuthenticationFilter extends OncePerRequestFilter {
     private final FirebaseAuthService firebaseAuthService;
     public  FirebaseAuthenticationFilter(FirebaseAuthService firebaseAuthService) {
         this.firebaseAuthService = firebaseAuthService;
     }
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
     //get the http request
        String header = request.getHeader("Authorization");
        //uf the header has no autherization header and does not start with X then reject request
        if(header == null || !header.startsWith("Bearer "))
        {
            filterChain.doFilter(request,response);
            return;
        }
        String authToken = header.substring(7);
        try{

           FirebaseToken decoded=firebaseAuthService.verifyToken(authToken);
           //create authentication object from verified token from firbase for spring security
            //credentials represents credentials such as email or password
            //third param represents users roles and authentications TODO Implement roles here later
           var authentication=new UsernamePasswordAuthenticationToken(decoded.getUid(),
                   null, Collections.emptyList());
           //indication of authenticated user to spring security
           SecurityContextHolder.getContext().setAuthentication(authentication);
        }catch(FirebaseAuthException e){
            e.printStackTrace();
            SecurityContextHolder.clearContext();
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setContentType("application/json");
            response.getWriter().write(
                    "{\"error\":\"invalid_token\"}"
            );
            return;
        }
        filterChain.doFilter(request,response);
    }
}
