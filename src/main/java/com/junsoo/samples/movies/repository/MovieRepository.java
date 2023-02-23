package com.junsoo.samples.movies.repository;

import com.junsoo.samples.movies.entity.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Integer> {
    Optional<Movie> findByMovieId(String id);
}