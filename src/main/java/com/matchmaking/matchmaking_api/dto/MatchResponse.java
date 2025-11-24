package com.matchmaking.matchmaking_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MatchResponse {
    private String message;
    private int playerAPoints;
    private int playerBPoints;
}
