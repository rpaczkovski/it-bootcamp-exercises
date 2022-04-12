package com.meli.movies.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter @Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "actors")
public class Actor extends BaseEntity {

    private String firstName;
    private String lastName;
    private Double rating;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "favorite_movie_id", referencedColumnName = "id")
    private Movie favoriteMovie;

    @ManyToMany(mappedBy = "actors")
    private Set<Movie> movies = new HashSet<>();

    @ManyToMany(mappedBy = "actors")
    private Set<Episode> episodes = new HashSet<>();


}
