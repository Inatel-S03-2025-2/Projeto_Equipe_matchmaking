package com.matchmaking.matchmaking_api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class MatchRequest {

    @NotBlank
    @Size(max = 100)
    private String playerAName;

    @NotBlank
    @Size(max = 100)
    private String playerAId;

    @NotBlank
    @Size(max = 100)
    private String playerBName;

    @NotBlank
    @Size(max = 100)
    private String playerBId;

    @NotBlank
    private String winner; // "A" or "B"

    public MatchRequest() {}

    // getters & setters
    public String getPlayerAName() { return playerAName; }
    public void setPlayerAName(String playerAName) { this.playerAName = playerAName; }
    public String getPlayerAId() { return playerAId; }
    public void setPlayerAId(String playerAId) { this.playerAId = playerAId; }
    public String getPlayerBName() { return playerBName; }
    public void setPlayerBName(String playerBName) { this.playerBName = playerBName; }
    public String getPlayerBId() { return playerBId; }
    public void setPlayerBId(String playerBId) { this.playerBId = playerBId; }
    public String getWinner() { return winner; }
    public void setWinner(String winner) { this.winner = winner; }
}
