package com.meli.movies.dto.response;

import com.meli.movies.entity.Genre;
import com.meli.movies.entity.Season;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class SerieResponse {
    private Long id;
    private String title;
    private LocalDate releaseDate;
    private LocalDate endDate;
    private Genre genre;
    private List<Season> seasons;
}
