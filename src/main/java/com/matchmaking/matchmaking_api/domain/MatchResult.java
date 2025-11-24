package com.matchmaking.matchmaking_api.domain;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "match_results")
public class MatchResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String playerAId;
    private String playerAName;
    private String playerBId;
    private String playerBName;

    private String winner;

    private int playerAPointsChange;
    private int playerBPointsChange;

    private Instant timestamp;

    public MatchResult() {}

    // getters & setters
    public Long getId() { return id; }
    public String getPlayerAId() { return playerAId; }
    public void setPlayerAId(String playerAId) { this.playerAId = playerAId; }
    public String getPlayerAName() { return playerAName; }
    public void setPlayerAName(String playerAName) { this.playerAName = playerAName; }
    public String getPlayerBId() { return playerBId; }
    public void setPlayerBId(String playerBId) { this.playerBId = playerBId; }
    public String getPlayerBName() { return playerBName; }
    public void setPlayerBName(String playerBName) { this.playerBName = playerBName; }
    public String getWinner() { return winner; }
    public void setWinner(String winner) { this.winner = winner; }
    public int getPlayerAPointsChange() { return playerAPointsChange; }
    public void setPlayerAPointsChange(int playerAPointsChange) { this.playerAPointsChange = playerAPointsChange; }
    public int getPlayerBPointsChange() { return playerBPointsChange; }
    public void setPlayerBPointsChange(int playerBPointsChange) { this.playerBPointsChange = playerBPointsChange; }
    public Instant getTimestamp() { return timestamp; }
    public void setTimestamp(Instant timestamp) { this.timestamp = timestamp; }
}
