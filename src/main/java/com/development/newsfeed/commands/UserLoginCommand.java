package com.development.newsfeed.commands;

import com.development.newsfeed.controller.UserController;
import com.development.newsfeed.dto.UserRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class UserLoginCommand implements Command{

    private UserController userController;

    @Autowired
    public UserLoginCommand(UserController userController){
        this.userController=userController;
    }
    @Override
    public boolean match(String input) {
        String lineInput="";
        int i=0;
        while(input.charAt(i)!='('){
            lineInput+=input.charAt(i);
            i++;
        }
        String remainInput=input.substring(i+1,input.length()-1);
        List<String> inputList= Arrays.stream(remainInput.split(",")).toList();

        if(lineInput.equalsIgnoreCase(CommandConstant.USER_LOGIN) && inputList.size()==2) return true;
        return false;
    }

    @Override
    public void execute(String input) {
        String lineInput="";
        int i=0;
        while(input.charAt(i)!='('){
            lineInput+=input.charAt(i);
            i++;
        }
        String remainInput=input.substring(i+1,input.length()-1);
        List<String> inputList= Arrays.stream(remainInput.split(",")).toList();

         if(lineInput.equalsIgnoreCase(CommandConstant.USER_LOGIN)){
             UserRequestDto userRequestDto=new UserRequestDto();
             userRequestDto.setEmail(inputList.get(0));
             userRequestDto.setPassword(inputList.get(1));

             userController.signIn(userRequestDto);
         }
    }
}
