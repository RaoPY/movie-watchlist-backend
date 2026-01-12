package com.movie.watchlist.controller;

import com.movie.watchlist.service.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    private final MovieService movieService;

    // constructor injection; cannot use @Autowired with final fields
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/search")
    public String searchMovie(@RequestParam String query) {
        return movieService.searchMovie(query);
    }
}
