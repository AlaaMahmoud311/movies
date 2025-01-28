package com.demo.movies.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.demo.movies.entity.Movie}
 */
@Value
@Data
public class MovieDto implements Serializable {
    @JsonProperty("Title")
    private String Title;
    @JsonProperty("Year")
    private String Year;
    @JsonProperty("Genre")
    private String Genre;
    @JsonProperty("imdbID")
    private String imdbID;
    @JsonProperty("Poster")
    private String Poster;
}