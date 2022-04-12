package com.meli.movies.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
public class MovieRequest {
    @JsonProperty("id")
    private Long id;

    @NotBlank
    @JsonProperty("title")
    private String title;

    @NotNull
    @JsonProperty("rating")
    private Double rating;

    @NotNull
    @JsonProperty("awards")
    private Integer awards;

    @NotNull
    @JsonProperty("releaseDate")
    private LocalDate releaseDate;

    @NotNull
    @JsonProperty("length")
    private Integer length;

    @JsonProperty("actors")
    @NotNull
    private Set<ActorRequest> actors;

    @JsonProperty("genre")
    @NotNull
    private GenreRequest genre;
}
