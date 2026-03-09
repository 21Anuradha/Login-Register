package com.login_register.login_register_user.service;

import com.login_register.login_register_user.model.User;
import com.login_register.login_register_user.reository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User register(User user) {
        return userRepository.save(user);
    }

    public String login(String email, String password) {
        User user = userRepository.findByEmail(email);

        if (user == null){
            return  "User not found";
        }
        if (!user.getPassword().equals(password)){
            return  "Wrong Password";
        }

        return "Login Successful";
    }
}
