package com.matchmaking.matchmaking_api.service;

import org.springframework.stereotype.Component;

@Component
public class DefaultScoringStrategy implements ScoringStrategy {

    private static final int WIN = 20;
    private static final int LOSE = -10;

    @Override
    public int[] compute(String winner) {
        if (winner == null) throw new IllegalArgumentException("winner cannot be null");
        String w = winner.trim().toUpperCase();
        if ("A".equals(w)) {
            return new int[] { WIN, LOSE };
        } else if ("B".equals(w)) {
            return new int[] { LOSE, WIN };
        } else {
            throw new IllegalArgumentException("winner must be 'A' or 'B'");
        }
    }
}
