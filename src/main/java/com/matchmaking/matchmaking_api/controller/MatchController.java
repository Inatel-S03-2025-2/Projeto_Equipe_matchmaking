package com.matchmaking.matchmaking_api.controller;

import com.matchmaking.matchmaking_api.dto.MatchRequest;
import com.matchmaking.matchmaking_api.dto.MatchResponse;
import com.matchmaking.matchmaking_api.service.MatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/matchmaking")
@RequiredArgsConstructor
public class MatchController {

    private final MatchService service;

    @PostMapping("/match")
    public MatchResponse match(@RequestBody MatchRequest request) {
        return service.registerMatch(request);
    }
}
