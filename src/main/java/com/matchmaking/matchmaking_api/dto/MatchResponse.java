package com.matchmaking.matchmaking_api.dto;

public class MatchResponse {

    private String message;
    private String playerAId;
    private String playerBId;

    public MatchResponse() {}

    public MatchResponse(String message, String playerAId, String playerBId) {
        this.message = message;
        this.playerAId = playerAId;
        this.playerBId = playerBId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPlayerAId() {
        return playerAId;
    }

    public void setPlayerAId(String playerAId) {
        this.playerAId = playerAId;
    }

    public String getPlayerBId() {
        return playerBId;
    }

    public void setPlayerBId(String playerBId) {
        this.playerBId = playerBId;
    }
}