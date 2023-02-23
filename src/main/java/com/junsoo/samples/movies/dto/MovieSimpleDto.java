package com.junsoo.samples.movies.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@JacksonStdImpl
@Builder
public class MovieSimpleDto {

	@JsonProperty(value = "Title")
	private String title;
	@JsonProperty(value = "Year")
	private String year;
	@JsonProperty(value = "Poster")
	private String poster;
	@JsonProperty(value = "imdbID")
	private String imdbId;
	@JsonProperty(value = "Type")
	private String type;

	public void setTitle(String title) {
		this.title = title;
	}
}
