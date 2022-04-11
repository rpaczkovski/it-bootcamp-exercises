package com.meli.turorials.application.usecase.tutorial.create;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CreateTutorialRequestModel {
    private String title;
    private String description;
    private boolean isPublic = false;
}
