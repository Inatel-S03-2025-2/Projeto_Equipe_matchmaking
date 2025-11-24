package com.matchmaking.matchmaking_api.service;

/**
 * Strategy pattern: calcula a alteração de pontos
 * Retorna array [deltaForA, deltaForB]
 */
public interface ScoringStrategy {
    int[] compute(String winner);
}
