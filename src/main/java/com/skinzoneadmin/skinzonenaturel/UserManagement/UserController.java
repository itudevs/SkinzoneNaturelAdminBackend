package com.skinzoneadmin.skinzonenaturel.UserManagement;

import com.skinzoneadmin.skinzonenaturel.Dtos.RegisterUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;

   @PostMapping("register")
    public Boolean registerUser(@RequestBody RegisterUserDto user){
       return userService.RegisterUser(user);
   }
}
