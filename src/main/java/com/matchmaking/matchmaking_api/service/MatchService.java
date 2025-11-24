package com.matchmaking.matchmaking_api.service;

import com.matchmaking.matchmaking_api.domain.MatchResult;
import com.matchmaking.matchmaking_api.domain.Player;
import com.matchmaking.matchmaking_api.dto.MatchRequest;
import com.matchmaking.matchmaking_api.repository.MatchResultJpaRepository;
import com.matchmaking.matchmaking_api.repository.PlayerJpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
public class MatchService {

    private final PlayerFactory playerFactory;
    private final ScoringStrategy scoringStrategy;
    private final PlayerJpaRepository playerRepo;
    private final MatchResultJpaRepository matchRepo;

    public MatchService(PlayerFactory playerFactory,
                        ScoringStrategy scoringStrategy,
                        PlayerJpaRepository playerRepo,
                        MatchResultJpaRepository matchRepo) {
        this.playerFactory = playerFactory;
        this.scoringStrategy = scoringStrategy;
        this.playerRepo = playerRepo;
        this.matchRepo = matchRepo;
    }

    @Transactional
    public MatchResult process(MatchRequest req) {
        // input validation
        if (req.getWinner() == null) throw new IllegalArgumentException("winner is required");

        // fetch or create Player A
        Player playerA = playerRepo.findById(req.getPlayerAId())
                .orElseGet(() -> playerFactory.create(req.getPlayerAId(), req.getPlayerAName()));

        // fetch or create Player B
        Player playerB = playerRepo.findById(req.getPlayerBId())
                .orElseGet(() -> playerFactory.create(req.getPlayerBId(), req.getPlayerBName()));

        // compute deltas
        int[] deltas = scoringStrategy.compute(req.getWinner()); // [deltaA, deltaB]

        // apply deltas
        playerA.setPoints(playerA.getPoints() + deltas[0]);
        playerB.setPoints(playerB.getPoints() + deltas[1]);

        // persist players
        playerRepo.save(playerA);
        playerRepo.save(playerB);

        // create match result record
        MatchResult r = new MatchResult();
        r.setPlayerAId(playerA.getId());
        r.setPlayerAName(playerA.getName());
        r.setPlayerBId(playerB.getId());
        r.setPlayerBName(playerB.getName());
        r.setWinner(req.getWinner().trim().toUpperCase());
        r.setPlayerAPointsChange(deltas[0]);
        r.setPlayerBPointsChange(deltas[1]);
        r.setTimestamp(Instant.now());

        return matchRepo.save(r);
    }
}
