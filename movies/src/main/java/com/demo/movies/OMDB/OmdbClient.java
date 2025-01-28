package com.demo.movies.OMDB;


import com.demo.movies.DTO.MovieDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "alaa0", url = "https://www.omdbapi.com")
@Component
public interface OmdbClient {

    @GetMapping
    MovieDto getMovieDetails(@RequestParam("i") String imdbId, @RequestParam("apikey") String key);
}
