package com.demo.movies.service;

import com.demo.movies.entity.Role;
import com.demo.movies.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleService {
    
    private final RoleRepository roleRepository;

    public Role findByName(String name){
        return roleRepository.findByName(name).orElse(null);
    }

}