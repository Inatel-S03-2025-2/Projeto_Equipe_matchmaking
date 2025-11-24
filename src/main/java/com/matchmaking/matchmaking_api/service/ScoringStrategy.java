package com.matchmaking.matchmaking_api.service;

public interface ScoringStrategy {
    int[] compute(String winner);
}
