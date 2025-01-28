package com.demo.movies.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String year;
    private String genre;
    private String imdbId;
    private String poster;

    private Boolean adminAdded;
    @ManyToMany(mappedBy = "movies")
    private Set<UserEntity> users = new HashSet<>();
}
