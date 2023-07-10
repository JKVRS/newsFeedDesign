package com.development.newsfeed.commands;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CommandRegistery {

    List<Command> commandList;
   // private UserRegisterCommand userRegisterCommand;

    @Autowired
    public CommandRegistery(UserRegisterCommand userRegisterCommand,UserLoginCommand userLoginCommand){
        commandList=new ArrayList<>();
        commandList.add(userRegisterCommand);
        commandList.add(userLoginCommand);
    }

    public void Execute(String input){

        for(Command command:commandList){
            if(command.match(input)){
                command.execute(input);
                break;
            }
        }
    }
}
