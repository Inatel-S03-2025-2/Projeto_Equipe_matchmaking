package com.matchmaking.matchmaking_api.controller;

import com.matchmaking.matchmaking_api.domain.Player;
import com.matchmaking.matchmaking_api.service.MatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/players")
@RequiredArgsConstructor
public class PlayerController {

    private final MatchService service;

    @GetMapping
    public List<Player> listPlayers() {
        return service.listPlayers();
    }
}
