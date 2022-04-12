package com.meli.movies.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "seasons")
public class Season extends BaseEntity {

    private String title;
    private Integer number;
    private LocalDate releaseDate;
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "serie_id")
    private Serie serie;

    @OneToMany(mappedBy = "season")
    private List<Episode> episodes;

}
