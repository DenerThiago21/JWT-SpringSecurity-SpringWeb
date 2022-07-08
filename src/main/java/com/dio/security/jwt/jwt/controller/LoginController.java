package com.dio.security.jwt.jwt.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dio.security.jwt.jwt.dto.Login;
import com.dio.security.jwt.jwt.dto.Sessao;
import com.dio.security.jwt.jwt.model.User;
import com.dio.security.jwt.jwt.repository.UserRepository;
import com.dio.security.jwt.jwt.security.config.SecurityConfig;
import com.dio.security.jwt.jwt.security.jwt.JWTCreator;
import com.dio.security.jwt.jwt.security.jwt.JWTObject;

@RestController
public class LoginController {
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private SecurityConfig securityConfig;
    @Autowired
    private UserRepository repository;

    @PostMapping("/login")
    public Sessao logar(@RequestBody Login login) {
        User user = repository.findByUsername(login.getUsername());
        if(user != null) {
            boolean passwordOk = encoder.matches(login.getPassword(), user.getPassword());
            if(!passwordOk) {
                throw new RuntimeException("Senha inválida para login: " + login.getUsername());
            }
            //estamos enviando um objeto sessao para retornar mais informações do usuario
            Sessao sessao = new Sessao();
            sessao.setLogin(user.getUsername());

            JWTObject jwtObject = new JWTObject();
            jwtObject.setIssuedAt(new Date(System.currentTimeMillis()));
            jwtObject.setExpiration((new Date(System.currentTimeMillis() + SecurityConfig.EXPIRATION)));
            jwtObject.setRoles(user.getRoles());
            sessao.setToken(JWTCreator.create(SecurityConfig.PREFIX, SecurityConfig.KEY, jwtObject));
            return sessao;
        } else {
            throw new RuntimeException("Erro ao fazer login: ");
        }
    }
}
