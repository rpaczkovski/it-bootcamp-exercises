package com.meli.movies.dto.response;

import com.meli.movies.entity.Episode;
import com.meli.movies.entity.Season;
import com.meli.movies.entity.Serie;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class SeasonResponse {
    private Long id;
    private String title;
    private Integer number;
    private LocalDate releaseDate;
    private LocalDate endDate;
    private Serie serie;
    private List<Episode> episodes;
    private Season season;
}
