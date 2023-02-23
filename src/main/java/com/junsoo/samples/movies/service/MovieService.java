package com.junsoo.samples.movies.service;

import com.junsoo.samples.movies.entity.Movie;
import com.junsoo.samples.movies.dto.MovieDto;
import com.junsoo.samples.movies.dto.MovieSimpleDto;
import com.junsoo.samples.movies.dto.SearchDto;
import com.junsoo.samples.movies.error.NotFoundException;
import com.junsoo.samples.movies.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor    // inject dependency
public class MovieService {

	@Value("${com.junsoo.samples.movies.omdb.api-key}")
	private String apiKey;
	@Value("${com.junsoo.samples.movies.omdb.url}")
	private String omdbUrl;
	@Value("${com.junsoo.samples.movies.omdb.detail-url}")
	private String omdbDetailUrl;
	private final RestTemplate restTemplate;

	@Autowired
	private MovieRepository repository;

	/**
	 * search movies
	 * @param movieTitle
	 * @return
	 */
	public List<MovieSimpleDto> find(final String movieTitle) {
		String rUrl = MessageFormat.format(omdbUrl, apiKey, movieTitle);
		final var response = restTemplate.getForEntity(rUrl, SearchDto.class);
		final var searchDto = response.getBody();
		if (response.getStatusCode().equals(HttpStatus.NOT_FOUND) || !searchDto.getResponse().equalsIgnoreCase("TRUE")) {
			return new ArrayList<>();
		}

		// get title from db
		searchDto.getMovies().stream().forEach(m -> {
			var movie = repository.findByMovieId(m.getImdbId());
			if(movie.isPresent())
				m.setTitle(movie.get().getTitle());
		});


		return searchDto.getMovies();

	}

	/**
	 * find a movie by id
	 * @param id
	 * @return
	 */
	public MovieDto findById(final String id) {
		String rUrl = MessageFormat.format(omdbDetailUrl, apiKey, id);
		final var response = restTemplate.getForEntity(rUrl, MovieDto.class);
		final var dto = response.getBody();
		if (response.getStatusCode().equals(HttpStatus.NOT_FOUND) || !dto.getResponse().equalsIgnoreCase("TRUE")) {
			throw new NotFoundException(id);
		}

		// get title from db
		var movie = repository.findByMovieId(id);
		if(movie.isPresent())
			dto.setTitle(movie.get().getTitle());

		return dto;

	}

	// create or update title
	public void createOrUpdateTitle(final String id, final String title) {
		var movie = repository.findByMovieId(id);
		Movie domain = new Movie(id, title);
		if (movie.isPresent())
			domain = movie.get();

		domain.setTitle(title);
		repository.save(domain);
	}

}
