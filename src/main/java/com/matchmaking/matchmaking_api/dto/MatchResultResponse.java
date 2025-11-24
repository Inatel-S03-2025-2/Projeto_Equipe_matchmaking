package com.matchmaking.matchmaking_api.dto;

public class MatchResultResponse {
    private String message;
    private int playerAPoints;
    private int playerBPoints;

    public MatchResultResponse() {}

    public MatchResultResponse(String message, int playerAPoints, int playerBPoints) {
        this.message = message;
        this.playerAPoints = playerAPoints;
        this.playerBPoints = playerBPoints;
    }

    // getters & setters
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
    public int getPlayerAPoints() { return playerAPoints; }
    public void setPlayerAPoints(int playerAPoints) { this.playerAPoints = playerAPoints; }
    public int getPlayerBPoints() { return playerBPoints; }
    public void setPlayerBPoints(int playerBPoints) { this.playerBPoints = playerBPoints; }
}
