package com.meli.qa.qabugs.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Builder
@Entity
@Table(name = "test_cases")
public class TestCase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = true)
    private String description = null;
    private Boolean tested = false;
    private Boolean passed = false;
    private Integer numberOfTries;
    private LocalDate lastUpdate;

}
