package com.matchmaking.matchmaking_api.service;

import com.matchmaking.matchmaking_api.domain.Player;
import org.springframework.stereotype.Component;

/**
 * Factory pattern: centraliza criação de Player com valores default
 */
@Component
public class PlayerFactory {

    public Player create(String id, String name) {
        return new Player(id, name, 0); // start with 0 points
    }
}
