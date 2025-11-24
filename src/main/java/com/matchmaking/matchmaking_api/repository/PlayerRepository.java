package com.matchmaking.matchmaking_api.repository;

import com.matchmaking.matchmaking_api.domain.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, String> {
}
