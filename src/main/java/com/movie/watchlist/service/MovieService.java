package com.movie.watchlist.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieService {

    @Value("${movie.api.url}")
    private String movieApiUrl;

    @Value("${movie.api.key}")
    private String apiKey;

    // to make HTTP requests (call external APIs)
    private final RestTemplate restTemplate = new RestTemplate();

    public String searchMovie(String query) {
        String url = movieApiUrl + "?apikey=" + apiKey + "&s=" + query;
        return restTemplate.getForObject(url, String.class); // GET request to url; string response
    }
}
