package com.demo.movies.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name="users")
public class UserEntity {
    
     
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false , unique = true)
    private String email; // candidate key

    @Column(nullable = false)
    // @JsonIgnore
    private String password;
    
    @ManyToMany(cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    private List<Role> roles;

    @ManyToMany
    @JoinTable(
            name = "user_movies",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id")
    )
    private Set<Movie> movies = new HashSet<>();
}
