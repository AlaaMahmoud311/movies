package com.demo.movies.service;

import com.demo.movies.DTO.LoginRequestDTO;
import com.demo.movies.DTO.LoginResponseDTO;
import com.demo.movies.DTO.RegisterRequestDTO;
import com.demo.movies.entity.Role;
import com.demo.movies.entity.UserEntity;
import com.demo.movies.security.JWTGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserService userService;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JWTGenerator jwtGenerator;
    public UserEntity register(RegisterRequestDTO registerRequestDTO){
        
        if (userService.existsByEmail(registerRequestDTO.getEmail())) {
        }

        if (registerRequestDTO.getPassword() != registerRequestDTO.getConfirmPassword()) {
        }

        UserEntity user = new UserEntity();
        Role role = roleService.findByName("USER"); 
        
        user.setName(registerRequestDTO.getName());
        user.setEmail(registerRequestDTO.getEmail());
        user.setPassword(passwordEncoder.encode(registerRequestDTO.getPassword()));
        user.setRoles(Collections.singletonList(role)); 
        return userService.save(user);
    }


    public LoginResponseDTO login(LoginRequestDTO loginRequestDTO){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequestDTO.getEmail(), loginRequestDTO.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtGenerator.generateToken(authentication);

        LoginResponseDTO loginResponseDTO = new LoginResponseDTO();
        loginResponseDTO.setEmail(loginRequestDTO.getEmail());
        loginResponseDTO.setToken(token);

        return loginResponseDTO;
    }


}