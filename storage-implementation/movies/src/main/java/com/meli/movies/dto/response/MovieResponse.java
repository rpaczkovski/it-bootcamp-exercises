package com.meli.movies.dto.response;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class MovieResponse {
    private Long id;
    private String title;
    private Double rating;
    private Integer awards;
    private LocalDate releaseDate;
    private Integer length;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private List<ActorResponse> actors;
}
