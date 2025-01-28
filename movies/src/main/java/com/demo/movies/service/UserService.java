package com.demo.movies.service;

import com.demo.movies.entity.UserEntity;
import com.demo.movies.exception.UserNotFoundException;
import com.demo.movies.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    
    
    private final UserRepository userRepository;

    public UserEntity getUserById(Integer userId){
        return userRepository.findById(userId).orElseThrow(()-> new UserNotFoundException("User Not Found with that id :"+ userId));
    }

    public List<UserEntity> getAllUsers(){
        return userRepository.findAll();
    }

    public UserEntity getUserByEmail(String email){
        return userRepository.findUserByEmail(email).orElse(null);
    }

    public boolean existsByEmail(String email){
        return userRepository.existsByEmail(email);
    }

    public UserEntity save(UserEntity user){
        return userRepository.save(user);
    }

}
