package com.meli.turorials.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Tutorial {

    private Long id;
    private String title;
    private String description;
    private boolean isPublic = false;


    public Tutorial(String title, String description, boolean isPublic) {
        this.title = title;
        this.description = description;
        this.isPublic = isPublic;
    }

    public void update(String title, String description, Boolean isPublic) {
        this.title = title;
        this.description = description;
        if(isPublic != null && isPublic != this.isPublic) {
            this.isPublic = isPublic;
        }
    }

}
