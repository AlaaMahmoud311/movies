package com.demo.movies.service;

import com.demo.movies.entity.Movie;
import com.demo.movies.exception.MovieNotFoundException;
import com.demo.movies.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;


    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie getMovieById(Long id) {
        return movieRepository.findById(id)
                .orElseThrow(() -> new MovieNotFoundException("Movie not found with id: " + id));
    }

    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }

   public Movie updateMovie(Long id, Movie updatedMovie) {
        Movie existingMovie = getMovieById(id);


        existingMovie.setTitle(updatedMovie.getTitle());
        existingMovie.setYear(updatedMovie.getYear());
        existingMovie.setGenre(updatedMovie.getGenre());
        existingMovie.setImdbId(updatedMovie.getImdbId());
        existingMovie.setPoster(updatedMovie.getPoster());

        return movieRepository.save(existingMovie);
    }

    public void deleteMovie(Long id) {
        Movie movie = getMovieById(id);
        movieRepository.delete(movie);
    }
}
