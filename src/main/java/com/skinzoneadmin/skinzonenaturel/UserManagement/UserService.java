package com.skinzoneadmin.skinzonenaturel.UserManagement;

import com.skinzoneadmin.skinzonenaturel.Dtos.LoginUserDto;
import com.skinzoneadmin.skinzonenaturel.Dtos.RegisterUserDto;
import com.skinzoneadmin.skinzonenaturel.Entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public boolean RegisterUser(RegisterUserDto user){
        if(!userRepository.findByEmail(user.Email())){
            try {
                User NewUser = new User();
                NewUser.setEmail(user.Email());
                NewUser.setName(user.Name());
                NewUser.setSurname(user.Surname());
                NewUser.setContactNumber(String.valueOf(user.ContactNumber()));
                NewUser.setFirebase_uid(user.Uid());
                userRepository.save(NewUser);
                return true;
            }catch (Exception e){
                System.out.println("Error in RegisterUser");
                return false;
            }
        }
        return false;
    }
    public LoginUserDto LoginUser(String email, String password){
        return null;
    }
}
