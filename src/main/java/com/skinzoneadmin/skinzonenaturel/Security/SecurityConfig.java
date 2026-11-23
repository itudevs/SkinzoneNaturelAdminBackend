package com.skinzoneadmin.skinzonenaturel.Security;

import com.google.firebase.auth.FirebaseToken;
import com.skinzoneadmin.skinzonenaturel.Firebase.FirebaseAuthService;
import com.skinzoneadmin.skinzonenaturel.Firebase.FirebaseAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;

@Configuration
public class SecurityConfig {
    @Autowired
    WebConfiguration webConfiguration;
   @Bean
   public FirebaseAuthenticationFilter firebaseAuthenticationFilter(FirebaseAuthService firebaseAuthService) throws IOException {
       return new FirebaseAuthenticationFilter(firebaseAuthService);
   }
   @Bean
    public SecurityFilterChain securityFilterChain(FirebaseAuthenticationFilter firebaseAuthenticationFilter, HttpSecurity http) throws IOException {
       http   .cors(cors -> cors.configurationSource(webConfiguration.corsConfigurationSource()))
               .csrf(csrf -> csrf.disable()).sessionManagement(session->session.sessionCreationPolicy(
               SessionCreationPolicy.STATELESS
       )).authorizeHttpRequests(
               auth->auth.requestMatchers("/skinzone/admin/**").permitAll().anyRequest().authenticated()

       ).addFilterBefore(firebaseAuthenticationFilter,
               UsernamePasswordAuthenticationFilter.class);
       return http.build();
   }
}
