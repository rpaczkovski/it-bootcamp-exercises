package com.meli.turorials.application.usecase.tutorial.update;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdateTutorialRequestModel {
    private String title;
    private String description;
    private boolean isPublic;
}
