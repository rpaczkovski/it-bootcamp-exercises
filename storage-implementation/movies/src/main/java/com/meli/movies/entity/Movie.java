package com.meli.movies.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "movies")
public class Movie extends BaseEntity {

    @Basic
    @Column
    private String title;

    @Basic
    @Column
    private Double rating;

    @Basic
    @Column
    private Integer awards;

    @Basic
    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Basic
    @Column
    private Integer length;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "actor_movie",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id"))
    private Set<Actor> actors = new HashSet<>();


    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;


    public void updateEntity(String title, Double rating, Integer awards, LocalDate releaseDate, Integer length, Set<Actor> actors, Genre genre) {
        this.title = title;
        this.rating = rating;
        this.awards = awards;
        this.releaseDate = releaseDate;
        this.length = length;
        this.actors = actors;
        this.genre = genre;
    }
}
