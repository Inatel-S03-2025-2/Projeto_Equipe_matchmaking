package com.matchmaking.matchmaking_api.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "players")
public class Player {

    @Id
    @Column(name = "id", length = 100)
    private String id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "points", nullable = false)
    private int points;

    public Player() {}

    public Player(String id, String name, int points) {
        this.id = id;
        this.name = name;
        this.points = points;
    }

    // getters / setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getPoints() { return points; }
    public void setPoints(int points) { this.points = points; }
}
