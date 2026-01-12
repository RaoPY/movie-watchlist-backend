package com.movie.watchlist.service;

import com.movie.watchlist.dto.UpdateWatchlistMovieRequestDto;
import com.movie.watchlist.entity.User;
import com.movie.watchlist.entity.WatchlistMovie;
import com.movie.watchlist.repository.WatchlistRepository;
import org.springframework.stereotype.Service;

@Service
public class WatchlistService {

    // constructor injection; cannot use @Autowired with final fields
    private final WatchlistRepository watchlistRepository;

    public WatchlistService(WatchlistRepository watchlistRepository) {
        this.watchlistRepository = watchlistRepository;
    }

    public WatchlistMovie updateMovie(Long id, UpdateWatchlistMovieRequestDto request, User currentUser) {

        WatchlistMovie movie = watchlistRepository.findById(id).orElseThrow(() -> new RuntimeException("Movie not found"));

        if (!movie.getUser().getId().equals(currentUser.getId())) {
            throw new RuntimeException("Unauthorized");
        }

        if (request.getStatus() != null) {
            movie.setStatus(request.getStatus());
        }

        if (request.getRating() != null) {
            movie.setRating(request.getRating());
        }

        return watchlistRepository.save(movie);
    }
}
