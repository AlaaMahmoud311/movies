package com.demo.movies.service;

import com.demo.movies.DTO.MovieDto;
import com.demo.movies.OMDB.OmdbClient;
import com.demo.movies.OMDB.OmdbConfig;
import com.demo.movies.entity.Movie;
import com.demo.movies.repository.MovieRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OmdbService {

    private final OmdbClient omdbClient;
    private final OmdbConfig omdbConfig;
    private final MovieRepository movieRepository;


    public OmdbService(OmdbClient omdbClient, OmdbConfig omdbConfig, MovieRepository movieRepository) {
        MovieDto movie = omdbClient.getMovieDetails("tt3896198", "feee46");
        this.omdbClient = omdbClient;
        this.omdbConfig = omdbConfig;
        this.movieRepository = movieRepository;
    }


@Transactional
    public Movie saveMovieDetails() {

        MovieDto response = omdbClient.getMovieDetails("tt3896198", "feee46");

        Movie movie = new Movie();
        System.out.println(movie.toString());
        movie.setTitle(response.getTitle());
        movie.setYear(response.getYear());
        movie.setGenre(response.getGenre());
        movie.setImdbId(response.getImdbID());
        movie.setPoster(response.getPoster());

        return movieRepository.save(movie);
    }
}


