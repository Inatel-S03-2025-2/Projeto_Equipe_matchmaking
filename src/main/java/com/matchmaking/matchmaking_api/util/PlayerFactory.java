package com.matchmaking.matchmaking_api.util;

import com.matchmaking.matchmaking_api.domain.Player;

public class PlayerFactory {

    private PlayerFactory() {
        // Evita instâncias da classe utilitária
    }

    public static Player create(String id, String name) {
        return new Player(id, name);
    }
}