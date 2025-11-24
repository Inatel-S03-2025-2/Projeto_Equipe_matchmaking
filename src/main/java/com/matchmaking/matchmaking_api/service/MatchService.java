package com.matchmaking.matchmaking_api.service;

import com.matchmaking.matchmaking_api.domain.Player;
import com.matchmaking.matchmaking_api.dto.MatchRequest;
import com.matchmaking.matchmaking_api.dto.MatchResponse;
import com.matchmaking.matchmaking_api.repository.PlayerRepository;
import com.matchmaking.matchmaking_api.util.PlayerFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MatchService {

    private final PlayerRepository repository;

    public MatchResponse registerMatch(MatchRequest req) {

        Player a = repository.findById(req.getPlayerAId())
                .orElse(PlayerFactory.create(req.getPlayerAId(), req.getPlayerAName()));

        Player b = repository.findById(req.getPlayerBId())
                .orElse(PlayerFactory.create(req.getPlayerBId(), req.getPlayerBName()));

        if (req.getWinner().equalsIgnoreCase("A")) {
            a.addWin();
            b.addLoss();
        } else {
            b.addWin();
            a.addLoss();
        }

        repository.save(a);
        repository.save(b);

        return new MatchResponse("Partida registrada com sucesso", a.getPoints(), b.getPoints());
    }

    public java.util.List<Player> listPlayers() {
        return repository.findAll();
    }
}
