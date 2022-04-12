package com.meli.movies.dto.response;

import com.meli.movies.entity.Actor;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
public class EpisodeResponse {
    private Long id;
    private String title;
    private Integer number;
    private LocalDate releaseDate;
    private Double rating;
    private Set<Actor> actors;
}
