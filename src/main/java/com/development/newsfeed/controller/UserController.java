package com.development.newsfeed.controller;

import com.development.newsfeed.dto.UserRequestDto;
import com.development.newsfeed.dto.UserResponseDto;
import com.development.newsfeed.exception.InvalidArgumentException;
import com.development.newsfeed.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component
@Controller
public class UserController {

   private  final UserService userService;

   @Autowired
   public UserController(UserService userService){
       this.userService=userService;
   }

    public UserResponseDto signUp(UserRequestDto userRequestDto){
       UserResponseDto userResponseDto=new UserResponseDto();
        try {
            userService.userRegister(userRequestDto.getName(),
                                   userRequestDto.getEmail(),
                                   userRequestDto.getPassword());
            userResponseDto.setName(userRequestDto.getName());
            userResponseDto.setResponseStatus(200);
            userResponseDto.setResponseMessage("User has sign up successfully !");
        } catch (InvalidArgumentException e) {
            userResponseDto.setResponseStatus(-200);
            userResponseDto.setResponseMessage("Something went wrong !");
        }
        return userResponseDto;
    }

    public UserResponseDto signIn(UserRequestDto userRequestDto){
         UserResponseDto userResponseDto=new UserResponseDto();
        try {
            userService.loginUser(userRequestDto.getEmail(),
                                 userRequestDto.getPassword());
            userResponseDto.setName(userRequestDto.getName());
            userResponseDto.setResponseStatus(300);
            userResponseDto.setResponseMessage("User has successfully loged in !");
        } catch (InvalidArgumentException e) {
            userResponseDto.setResponseStatus(-300);
            userResponseDto.setResponseMessage("some thing went wrong in login !");
        }
        return userResponseDto;
    }
}
