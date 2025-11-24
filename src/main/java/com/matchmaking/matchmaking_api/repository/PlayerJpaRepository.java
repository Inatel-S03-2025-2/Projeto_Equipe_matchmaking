package com.matchmaking.matchmaking_api.repository;

import com.matchmaking.matchmaking_api.domain.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerJpaRepository extends JpaRepository<Player, String> {
    // basic CRUD available
}
