package com.junsoo.samples.movies.controller;

import com.junsoo.samples.movies.service.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


import lombok.AllArgsConstructor;

import static com.junsoo.samples.movies.config.Constants.*;

@Controller
@AllArgsConstructor
public class SearchController {



	private final MovieService movieService;

	@GetMapping(value = "/")
	public String indexHandler() {
		return LIST;
	}


	@GetMapping(value = "/list")
	public String list(@RequestParam("title") final String movieTitle, final Model model) {
		System.out.println("LIST");

		final var movies = movieService.find(movieTitle);

		if (movies == null || movies.isEmpty())
			return NOT_FOUND;

		model.addAttribute("movies", movies);
		return LIST;
	}

	@GetMapping(value = "/movie")
	public String detail(@RequestParam("id") final String id, final Model model) {
		System.out.println("LIST");

		final var movie = movieService.findById(id);

		if (movie == null)
			return NOT_FOUND;

		model.addAttribute("movie", movie);
		return DETAIL;
	}

}
