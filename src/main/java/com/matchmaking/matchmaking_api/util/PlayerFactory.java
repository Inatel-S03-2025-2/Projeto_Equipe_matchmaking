package com.matchmaking.matchmaking_api.util;

import com.matchmaking.matchmaking_api.domain.Player;

public class PlayerFactory {

    public static Player create(String id, String name) {
        Player p = new Player();
        p.setId(id);
        p.setName(name);
        p.setPoints(0);
        return p;
    }
}
