package com.development.newsfeed.commands;

import com.development.newsfeed.controller.UserController;
import com.development.newsfeed.dto.UserRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class UserRegisterCommand implements Command{
    private final UserController userController;

    @Autowired
    public UserRegisterCommand(UserController userController){
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

        if(lineInput.equalsIgnoreCase(CommandConstant.USER_SINGUP) && inputList.size()==3) return true;
        return false;
    }

    @Override
    public void execute(String input) {
        String lineInput="";
        int index=0;
        while(input.charAt(index)!='('){
            lineInput+=input.charAt(index);
            index++;
        }
        String remainInput=input.substring(index+1,input.length()-1);
        List<String> inputList= Arrays.stream(remainInput.split(",")).toList();

        if(lineInput.equalsIgnoreCase(CommandConstant.USER_SINGUP)){

            UserRequestDto userRequestDto=new UserRequestDto();
            userRequestDto.setName(inputList.get(0));
            userRequestDto.setEmail(inputList.get(1));
            userRequestDto.setPassword(inputList.get(2));

            userController.signUp(userRequestDto);
        }

    }
}
