package com.meli.movies.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "genres")
public class Genre extends BaseEntity {

    @Basic
    @Column
    private String name;

    @Basic
    @Column
    private Integer ranking;

    @Basic
    @Column
    private Boolean active;

    @OneToMany(mappedBy = "genre")
    private List<Serie> series;

    @OneToMany(mappedBy = "genre")
    private List<Movie> movies;
}
