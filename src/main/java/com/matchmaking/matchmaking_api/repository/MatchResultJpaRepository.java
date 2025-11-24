package com.matchmaking.matchmaking_api.repository;

import com.matchmaking.matchmaking_api.domain.MatchResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchResultJpaRepository extends JpaRepository<MatchResult, Long> {
    List<MatchResult> findByPlayerAIdOrPlayerBId(String playerAId, String playerBId);
}
