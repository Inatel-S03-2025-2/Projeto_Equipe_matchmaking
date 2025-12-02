package com.matchmaking.matchmaking_api.service;

import com.matchmaking.matchmaking_api.domain.MatchResult;
import com.matchmaking.matchmaking_api.domain.Player;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MatchService {

    private final List<Player> players = new ArrayList<>();
    private final List<MatchResult> matches = new ArrayList<>();

    public MatchResult registerMatch(MatchResult matchRequest) {

        ensurePlayerExists(matchRequest.getPlayerAId(), matchRequest.getPlayerAName());
        ensurePlayerExists(matchRequest.getPlayerBId(), matchRequest.getPlayerBName());

        matches.add(matchRequest);

        return matchRequest;
    }

    public List<Player> listPlayers() {
        return new ArrayList<>(players);
    }

    public List<MatchResult> listAllMatches() {
        return new ArrayList<>(matches);
    }

    public List<MatchResult> listMatchesByPlayer(String playerId) {
        List<MatchResult> result = new ArrayList<>();
        for (MatchResult match : matches) {
            if (match.getPlayerAId().equals(playerId) || match.getPlayerBId().equals(playerId)) {
                result.add(match);
            }
        }
        return result;
    }

    private void ensurePlayerExists(String id, String name) {
        Optional<Player> existing = players.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
        if (existing.isEmpty()) {
            players.add(new Player(id, name));
        }
    }
}