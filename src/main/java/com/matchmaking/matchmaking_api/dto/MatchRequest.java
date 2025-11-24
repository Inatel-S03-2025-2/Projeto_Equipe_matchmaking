package com.matchmaking.matchmaking_api.dto;

import lombok.Data;

@Data
public class MatchRequest {
    private String playerAName;
    private String playerAId;

    private String playerBName;
    private String playerBId;

    private String winner; // "A" ou "B"
}
