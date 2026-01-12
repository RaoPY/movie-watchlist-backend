package com.movie.watchlist.dto;

import lombok.Getter;
import lombok.Setter;
//import lombok.NoArgsConstructor;

@Getter
@Setter
//@NoArgsConstructor
public class RegisterRequestDto {
    private String username;
    private String password;
}
