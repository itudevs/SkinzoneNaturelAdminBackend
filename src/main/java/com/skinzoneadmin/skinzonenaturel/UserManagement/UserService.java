package com.skinzoneadmin.skinzonenaturel.UserManagement;

import com.skinzoneadmin.skinzonenaturel.Dtos.LoginUserDto;
import com.skinzoneadmin.skinzonenaturel.Dtos.RegisterUserDto;
import com.skinzoneadmin.skinzonenaturel.Entities.User;
import com.skinzoneadmin.skinzonenaturel.Firebase.FirebaseAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    private FirebaseAuthService firebaseAuthService;
    public boolean RegisterUser(RegisterUserDto user, Authentication authentication){
        //find user linked to firebase id to avoid any injection of details from another user
        if(userRepository.findUserByFirebaseUid(authentication.getName()).isEmpty()){
            try {
                User NewUser = new User();
                NewUser.setEmail(user.Email());
                NewUser.setName(user.Name());
                NewUser.setSurname(user.Surname());
                NewUser.setContactNumber(String.valueOf(user.ContactNumber()));
                NewUser.setFirebaseUid(user.Uid());
                NewUser.setActive(true); //TODO set false later so when newly registered user is not active when registered
                userRepository.save(NewUser);
                return true;
            }catch (Exception e){
                System.out.println("Error in RegisterUser");
                return false;
            }
        }
        return false;
    }
    public LoginUserDto LoginUser(String uId){
        //check if user exists
        Optional<User> user = userRepository.findUserByFirebaseUid(uId);
        if(user.isPresent()){
            User foundUser=user.get();
            if(!foundUser.isActive()) return null;
            return new LoginUserDto(foundUser.getEmail(), foundUser.getName(), foundUser.getSurname(), foundUser.getContactNumber());
        }
        return null;
    }

    public LoginUserDto Profile(String uId){
        //check if user exists
        Optional<User> user = userRepository.findUserByFirebaseUid(uId);
        if(user.isPresent()){
            User foundUser=user.get();
            if(!foundUser.isActive()) return null;
            return new LoginUserDto(foundUser.getEmail(), foundUser.getName(), foundUser.getSurname(), foundUser.getContactNumber());
        }
        return null;
    }
}
