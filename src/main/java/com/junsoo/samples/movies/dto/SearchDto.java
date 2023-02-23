package com.junsoo.samples.movies.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@JacksonStdImpl
@Builder
public class SearchDto {

	@JsonProperty(value = "Response")
	private String response;
	@JsonProperty(value = "totalResults")
	private Long totalResults;

	@JsonProperty(value = "Search")
	private List<MovieSimpleDto> movies;
}
