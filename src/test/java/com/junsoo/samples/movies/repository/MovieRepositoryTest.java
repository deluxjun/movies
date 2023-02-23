package com.junsoo.samples.movies.repository;

import com.junsoo.samples.movies.entity.Movie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
class MovieRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private MovieRepository repository;

    @Test
    void findByMovieId() {
        entityManager.persist(new Movie("tt0256415", "TestTitle"));
//        repository.save(new Movie("tt0256415", "TestTitle"));

        var movie = repository.findByMovieId("tt0256415");
        assertTrue(movie.isPresent());
    }
}