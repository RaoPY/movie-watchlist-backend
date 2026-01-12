package com.movie.watchlist.entity;

import com.movie.watchlist.enums.WatchStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "watchlist_movies")
@Getter
@Setter // can be avoided since we don't want setter for id field
public class WatchlistMovie {
    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String imdbId;

    private String year;

    @Enumerated(EnumType.STRING)
    private WatchStatus status; // PLAN_TO_WATCH, WATCHING, COMPLETED

    private Integer rating; // 1 to 5

    @ManyToOne(fetch = FetchType.LAZY) // many watchlist movies belong to one user
    @JoinColumn(name = "user_id") // foreign key (WatchlistMovie is owning side)
    private User user;
}
