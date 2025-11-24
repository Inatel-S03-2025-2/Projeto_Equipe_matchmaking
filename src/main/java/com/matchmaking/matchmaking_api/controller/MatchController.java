package com.matchmaking.matchmaking_api.controller;

import com.matchmaking.matchmaking_api.domain.MatchResult;
import com.matchmaking.matchmaking_api.dto.MatchRequest;
import com.matchmaking.matchmaking_api.dto.MatchResultResponse;
import com.matchmaking.matchmaking_api.repository.MatchResultJpaRepository;
import com.matchmaking.matchmaking_api.repository.PlayerJpaRepository;
import com.matchmaking.matchmaking_api.service.MatchService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/matchmaking")
public class MatchController {

    private final MatchService matchService;
    private final PlayerJpaRepository playerRepo;
    private final MatchResultJpaRepository matchRepo;

    public MatchController(MatchService matchService,
                           PlayerJpaRepository playerRepo,
                           MatchResultJpaRepository matchRepo) {
        this.matchService = matchService;
        this.playerRepo = playerRepo;
        this.matchRepo = matchRepo;
    }

    @PostMapping("/match")
    public ResponseEntity<MatchResultResponse> createMatch(@Valid @RequestBody MatchRequest req) {
        MatchResult saved = matchService.process(req);

        int pointsA = playerRepo.findById(req.getPlayerAId()).map(p -> p.getPoints()).orElse(0);
        int pointsB = playerRepo.findById(req.getPlayerBId()).map(p -> p.getPoints()).orElse(0);

        MatchResultResponse resp = new MatchResultResponse(
                "Partida registrada com sucesso",
                pointsA,
                pointsB
        );

        return ResponseEntity.ok(resp);
    }

    @GetMapping("/results")
    public ResponseEntity<List<MatchResult>> allResults() {
        return ResponseEntity.ok(matchRepo.findAll());
    }

    @GetMapping("/results/player/{playerId}")
    public ResponseEntity<List<MatchResult>> resultsForPlayer(@PathVariable String playerId) {
        return ResponseEntity.ok(matchRepo.findByPlayerAIdOrPlayerBId(playerId, playerId));
    }
}
