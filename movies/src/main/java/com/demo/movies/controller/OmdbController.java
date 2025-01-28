package com.demo.movies.controller;

import com.demo.movies.service.OmdbService;

public class OmdbController {
    private final OmdbService omdbService;

    public OmdbController(OmdbService omdbService) {
        this.omdbService = omdbService;
    }

//    @GetMapping("/movie")
//    public MovieDto getMovie(@RequestParam String imdbId) {
//        return omdbService.getMovieDetails(imdbId);
//    }
}
