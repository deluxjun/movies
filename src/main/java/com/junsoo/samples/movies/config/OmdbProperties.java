package com.junsoo.samples.movies.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties(prefix = "com.junsoo.samples.movies")
public class OmdbProperties {

	private OMDB omdb = new OMDB();

	@Data
	public class OMDB {
		private String apiKey;
		private String url;
	}

}
