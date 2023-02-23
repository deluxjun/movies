package com.junsoo.samples.movies.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Table(name = "MOVIE")
@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


    public Movie(String movieId, String title) {
        this.movieId = movieId;
        this.title = title;
    }

    @NotEmpty
    @Size(max = 45)
    private String movieId;

    @NotEmpty
    @Size(max = 45)
    private String title;

    public void setId(Integer id) {
        this.id = id;
    }
    public void setTitle(String title) {
        this.title = title;
    }

}