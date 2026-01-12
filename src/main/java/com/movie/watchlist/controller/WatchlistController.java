package com.movie.watchlist.controller;

import com.movie.watchlist.dto.UpdateWatchlistMovieRequestDto;
import com.movie.watchlist.entity.User;
import com.movie.watchlist.entity.WatchlistMovie;
import com.movie.watchlist.repository.UserRepository;
import com.movie.watchlist.repository.WatchlistRepository;
import com.movie.watchlist.service.WatchlistService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/watchlist")
public class WatchlistController {

    private final WatchlistRepository watchlistRepository;
    private final WatchlistService watchlistService;

    // constructor injection; cannot use @Autowired with final fields
    public WatchlistController(WatchlistRepository watchlistRepository, UserRepository userRepository, WatchlistService watchlistService) {
        this.watchlistRepository = watchlistRepository;
        this.watchlistService = watchlistService;
    }

    // get currently logged-in user from JWT
    private User getCurrentUser() {
        return (User) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
    }

    @PostMapping
    public WatchlistMovie addMovie(@RequestBody WatchlistMovie movie) {
        movie.setUser(getCurrentUser());
        return watchlistRepository.save(movie);
    }

    @GetMapping
    public Page<WatchlistMovie> getWatchlist(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size) {
        return watchlistRepository.findByUser(getCurrentUser(), PageRequest.of(page, size));
    }

    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable Long id) {
        User currentUser = getCurrentUser();

        WatchlistMovie movie = watchlistRepository
                .findByIdAndUser(id, currentUser)
                .orElseThrow(() -> new RuntimeException("Movie not found"));

        watchlistRepository.delete(movie);
    }

    @PatchMapping("/{id}")
    public WatchlistMovie updateMovie(@PathVariable Long id, @RequestBody UpdateWatchlistMovieRequestDto request) {
        User currentUser = getCurrentUser();
        return watchlistService.updateMovie(id, request, currentUser);
    }
}
