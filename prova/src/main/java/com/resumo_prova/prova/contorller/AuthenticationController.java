package com.resumo_prova.prova.contorller;

import com.resumo_prova.prova.enums.UserRole;
import com.resumo_prova.prova.model.AuthenticationDTO;
import com.resumo_prova.prova.model.RegisterDTO;
import com.resumo_prova.prova.model.UserModel;
import com.resumo_prova.prova.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository repository;


    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AuthenticationDTO data){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        data.login(),
                        data.password()
                )
        );
        return ResponseEntity.ok().build();
    }

    @PostMapping("/register")
    public ResponseEntity register(

            @RequestBody RegisterDTO data){
        UserModel user = new UserModel(
       data.login(),
                new BCryptPasswordEncoder()
                        .encode(data.password()),
                UserRole.USER
        );
        repository.save (user);
                return ResponseEntity.ok().build();
    }

}
