package com.meli.turorials.infrastructure.data;

import com.meli.turorials.domain.entity.Tutorial;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "tutorials")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TutorialTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "is_public", columnDefinition = "tinyint")
    private Boolean isPublic;

    @Column(name = "created_at")
    private LocalDate createdAt;

    public static Tutorial fromEntity(TutorialTable table) {
        return new Tutorial(
                table.getId(),
                table.getTitle(),
                table.getDescription(),
                table.getIsPublic()
        );
    }
}

