package com.matchmaking.matchmaking_api.domain;

public class MatchResult {

    private String playerAName;
    private String playerAId;
    private String playerBName;
    private String playerBId;
    private String winner;

    public MatchResult() {}

    public MatchResult(String playerAName, String playerAId, String playerBName, String playerBId, String winner) {
        this.playerAName = playerAName;
        this.playerAId = playerAId;
        this.playerBName = playerBName;
        this.playerBId = playerBId;
        this.winner = winner;
    }

    public String getPlayerAName() {
        return playerAName;
    }

    public void setPlayerAName(String playerAName) {
        this.playerAName = playerAName;
    }

    public String getPlayerAId() {
        return playerAId;
    }

    public void setPlayerAId(String playerAId) {
        this.playerAId = playerAId;
    }

    public String getPlayerBName() {
        return playerBName;
    }

    public void setPlayerBName(String playerBName) {
        this.playerBName = playerBName;
    }

    public String getPlayerBId() {
        return playerBId;
    }

    public void setPlayerBId(String playerBId) {
        this.playerBId = playerBId;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    @Override
    public String toString() {
        return "Match{" +
                "playerAName='" + playerAName + '\'' +
                ", playerAId='" + playerAId + '\'' +
                ", playerBName='" + playerBName + '\'' +
                ", playerBId='" + playerBId + '\'' +
                ", winner='" + winner + '\'' +
                '}';
    }
}