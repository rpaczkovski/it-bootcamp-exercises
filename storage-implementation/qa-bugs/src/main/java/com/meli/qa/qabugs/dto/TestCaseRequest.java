package com.meli.qa.qabugs.dto;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TestCaseRequest {
    private String description = null;
    private Boolean tested = false;
    private Boolean passed = false;
    @NotNull(message = "The field numberOfTries is mandatory.")
    @PositiveOrZero(message = "The field numberOfTries accepts only positive or zero value.")
    private Integer numberOfTries;
}
