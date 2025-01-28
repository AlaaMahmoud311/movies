package com.demo.movies.controller;

import com.demo.movies.entity.Movie;
import com.demo.movies.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdminMovieController {

        private final MovieService movieService;

        public AdminMovieController(MovieService movieService) {
            this.movieService = movieService;
        }

        @PostMapping
        public ResponseEntity<Movie> createMovie(@RequestBody Movie movie) {
            return new ResponseEntity<>(movieService.createMovie(movie), HttpStatus.CREATED);
        }

        @PutMapping("/{id}")
        public ResponseEntity<Movie> updateMovie(@PathVariable Long id, @RequestBody Movie movieDetails) {
            return ResponseEntity.ok(movieService.updateMovie(id, movieDetails));
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteMovie(@PathVariable Long id) {
            movieService.deleteMovie(id);
            return ResponseEntity.noContent().build();
        }

        @GetMapping
        public ResponseEntity<List<Movie>> getAllMovies() {
            return ResponseEntity.ok(movieService.getAllMovies());
        }

        @GetMapping("/{id}")
        public ResponseEntity<Movie> getMovieById(@PathVariable Long id) {
            return ResponseEntity.ok(movieService.getMovieById(id));
        }
    }

