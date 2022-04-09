package com.meli.qa.qabugs.dto;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TestCaseResponse {
    private Long idCase;
    private String description;
    private Boolean tested;
    private Boolean passed;
    private Integer numberOfTries;
    private LocalDate lastUpdate;
}
