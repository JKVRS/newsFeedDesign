package com.development.newsfeed.service;

import com.development.newsfeed.exception.InvalidArgumentException;
import com.development.newsfeed.model.Session;
import com.development.newsfeed.model.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public interface UserService {

    public User userRegister(String name, String email, String password) throws InvalidArgumentException;

    public Session loginUser(String email, String password) throws InvalidArgumentException;
}
