package com.demo.movies.repository;

import com.demo.movies.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity,Integer> {
    public Optional<UserEntity> findUserByEmail(String email);
    public boolean existsByEmail(String email);
}
