package com.development.newsfeed.service.impl;

import com.development.newsfeed.exception.InvalidArgumentException;
import com.development.newsfeed.model.Session;
import com.development.newsfeed.model.User;
import com.development.newsfeed.repository.SessionRepo;
import com.development.newsfeed.repository.UserRepo;
import com.development.newsfeed.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Component
@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private  final SessionRepo sessionRepo;
    @Autowired
    public UserServiceImpl(UserRepo userRepo, SessionRepo sessionRepo){
        this.userRepo=userRepo;
        this.sessionRepo=sessionRepo;
    }

    @Override
    public User userRegister(String name, String email, String password) throws InvalidArgumentException {
        //System.out.println(name+" "+email+" "+password);
        Optional<User>optionalUser=userRepo.findByEmail(email);
        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
        User user=new User();
        if(optionalUser.isEmpty()){
            user.setName(name);
            user.setEmail(email);
            user.setPassword(encoder.encode(password));
            user.setCreateDate(new Date());
            user.setLastModifyDate(new Date());
        }else{
            throw new InvalidArgumentException("user is already exist !");
        }

        return userRepo.save(user);

    }

    @Override
    public Session loginUser(String email, String password) throws InvalidArgumentException {
        Optional<User> optionalUser = userRepo.findByEmail(email);
        if (optionalUser.isEmpty()) {
            throw new InvalidArgumentException("user doesn't exist ! Please signup");
        }

        Session session = new Session();
        PasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        User user = optionalUser.get();
        String savedPassword = user.getPassword();
        if (!bCryptPasswordEncoder.matches(password, savedPassword)) {
            throw new InvalidArgumentException("Password doesn't match ! Retry");
        }

        // To generate token id using UUID inbuilt class than save that token with respect to user
        UUID uuid = UUID.randomUUID();
        String token = String.valueOf(uuid);
        session.setUser(user);
        session.setToken(token);
        session.setCreateDate(new Date());
        session.setLastModifyDate(new Date());
        return sessionRepo.save(session);
    }
}
