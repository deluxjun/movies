package com.junsoo.samples.movies.controller;

import com.junsoo.samples.movies.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UpdateController {

	private final MovieService movieService;

	@PostMapping(value = "/update")
	public void update(@RequestParam("id") final String movieId, @RequestParam("title") final String movieTitle, final Model model) {

		movieService.createOrUpdateTitle(movieId, movieTitle);

	}


}
