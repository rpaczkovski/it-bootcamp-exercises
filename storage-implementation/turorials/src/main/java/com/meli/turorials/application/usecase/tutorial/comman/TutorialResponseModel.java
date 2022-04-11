package com.meli.turorials.application.usecase.tutorial.comman;

import com.meli.turorials.domain.entity.Tutorial;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TutorialResponseModel {
    private Long id;
    private String title;
    private String description;
    private boolean isPublic;


    public static TutorialResponseModel fromDomain(Tutorial domain) {
        return new TutorialResponseModel(
                domain.getId(),
                domain.getTitle(),
                domain.getDescription(),
                domain.isPublic()
        );
    }
}
