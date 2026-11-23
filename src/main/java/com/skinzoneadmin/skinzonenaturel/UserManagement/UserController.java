package com.skinzoneadmin.skinzonenaturel.UserManagement;

import com.skinzoneadmin.skinzonenaturel.Dtos.LoginUserDto;
import com.skinzoneadmin.skinzonenaturel.Dtos.RegisterUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

   @PostMapping("/register")
    public Boolean registerUser(@RequestBody RegisterUserDto user, Authentication authentication) throws IOException {
       return userService.RegisterUser(user);
   }

    @PostMapping("/login")
    public LoginUserDto Login(Authentication authentication) throws IOException {
        LoginUserDto response=userService.LoginUser(authentication.getName());
        System.out.println(response);
        return response;
    }

    @GetMapping("/user")
    public LoginUserDto GetProfile(Authentication authentication) throws IOException {
        return userService.Profile(authentication.getName());
    }

}
