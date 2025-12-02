package com.matchmaking.matchmaking_api.controller;

import com.matchmaking.matchmaking_api.domain.MatchResult;
import com.matchmaking.matchmaking_api.domain.Player;
import com.matchmaking.matchmaking_api.dto.MatchRequest;
import com.matchmaking.matchmaking_api.dto.MatchResponse;
import com.matchmaking.matchmaking_api.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/matches")
public class MatchController {

    @Autowired
    private MatchService matchService;

    // POST: registra uma nova partida
    @PostMapping
    public MatchResponse registerMatch(@RequestBody MatchRequest request) {
        MatchResult result = matchService.registerMatch(
                new MatchResult(
                        request.getPlayerAName(),
                        request.getPlayerAId(),
                        request.getPlayerBName(),
                        request.getPlayerBId(),
                        request.getWinner()
                )
        );
        return new MatchResponse(
                "Match registered successfully",
                result.getPlayerAId(),
                result.getPlayerBId()
        );
    }

    // GET: lista todos os jogadores
    @GetMapping("/players")
    public List<Player> listPlayers() {
        return matchService.listPlayers();
    }

    // GET: lista todas as partidas
    @GetMapping
    public List<MatchResult> listAllMatches() {
        return matchService.listAllMatches();
    }

    // GET: lista partidas de um jogador específico
    @GetMapping("/{playerId}")
    public List<MatchResult> listMatchesByPlayer(@PathVariable String playerId) {
        return matchService.listMatchesByPlayer(playerId);
    }
}