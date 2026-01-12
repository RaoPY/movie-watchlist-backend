package com.movie.watchlist.dto;

import com.movie.watchlist.enums.WatchStatus;
import lombok.Getter;
import lombok.Setter;
//import lombok.NoArgsConstructor;

@Getter
@Setter
//@NoArgsConstructor
public class UpdateWatchlistMovieRequestDto {
    private WatchStatus status;
    private Integer rating;
}
