package com.demo.movies.repository;

import com.demo.movies.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    Movie findByImdbId(String imdbID);
    List<Movie> findByTitleContainingIgnoreCase(String title);
}