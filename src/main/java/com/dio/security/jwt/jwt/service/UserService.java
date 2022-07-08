package com.dio.security.jwt.jwt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.dio.security.jwt.jwt.model.User;
import com.dio.security.jwt.jwt.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder encoder;

    public void createUser(User user) {
        String pass = user.getPassword();
        //criptografando antes de salvar
        user.setPassword(encoder.encode(pass));
        repository.save(user); 
    }

    public void findAllUsers() {
        repository.findAll();
    }
    
}
