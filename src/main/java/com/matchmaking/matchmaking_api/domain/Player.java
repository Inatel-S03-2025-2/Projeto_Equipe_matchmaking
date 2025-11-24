package com.matchmaking.matchmaking_api.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Player {

    @Id
    private String id;

    private String name;

    private int points = 0;

    public void addWin() {
        this.points += 20;
    }

    public void addLoss() {
        this.points -= 10;

        if (this.points < 0) {
            this.points = 0;
        }
    }
}
