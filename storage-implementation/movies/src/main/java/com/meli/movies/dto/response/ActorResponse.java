package com.meli.movies.dto.response;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ActorResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private Double rating;
    private LocalDate createdAt;
    private LocalDate updatedAt;
}
