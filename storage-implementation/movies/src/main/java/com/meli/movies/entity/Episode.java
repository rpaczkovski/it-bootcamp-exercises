package com.meli.movies.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "episodes")
public class Episode extends BaseEntity {

    private String title;
    private Integer number;
    private LocalDate releaseDate;
    private Double rating;

    @ManyToMany
    @JoinTable(
            name = "actor_episode",
            joinColumns = @JoinColumn(name = "episode_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id")
    )
    private Set<Actor> actors;

    @ManyToOne
    @JoinColumn(name = "season_id")
    private Season season;

}
