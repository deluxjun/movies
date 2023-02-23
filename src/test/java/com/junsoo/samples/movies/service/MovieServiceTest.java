package com.junsoo.samples.movies.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class MovieServiceTest {

    @Autowired
    private MovieService movieService;

    @Test
    void find() {
        var results = movieService.find("Home");
        assertTrue(results.size() > 0 );
    }

    @Test
    void findById() {
        var result = movieService.findById("tt0256415");
        assertEquals(result.getImdbId(), "tt0256415");
    }

    @Test
    void createOrUpdateTitle() {
        movieService.createOrUpdateTitle("tt0256415", "Home");

        var result = movieService.findById("tt0256415");
        assertEquals(result.getImdbId(), "tt0256415");
    }

}