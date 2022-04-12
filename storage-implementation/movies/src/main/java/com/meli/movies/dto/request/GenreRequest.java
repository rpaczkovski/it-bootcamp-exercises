package com.meli.movies.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class GenreRequest {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("ranking")
    private Integer ranking;

    @JsonProperty("active")
    private Boolean active;
}
