package com.movie.watchlist.repository;

import com.movie.watchlist.entity.User;
import com.movie.watchlist.entity.WatchlistMovie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WatchlistRepository extends JpaRepository<WatchlistMovie, Long> {

    Optional<WatchlistMovie> findByIdAndUser(Long id, User user);

    Page<WatchlistMovie> findByUser(User user, Pageable pageable); // pagination
}
