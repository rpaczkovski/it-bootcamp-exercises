package com.meli.movies.dto.response;

import com.meli.movies.entity.Serie;
import lombok.Data;

import java.util.List;

@Data
public class GenreResponse {
    private Long id;
    private String name;
    private Integer ranking;
    private Boolean active;
    private List<Serie> series;
}
