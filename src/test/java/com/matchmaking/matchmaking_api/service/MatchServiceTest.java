package com.matchmaking.matchmaking_api.service;

import com.matchmaking.matchmaking_api.domain.Player;
import com.matchmaking.matchmaking_api.dto.MatchRequest;
import com.matchmaking.matchmaking_api.repository.PlayerRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class MatchServiceTest {

    @Test
    void testRegisterMatchNewPlayers() {

        PlayerRepository repo = Mockito.mock(PlayerRepository.class);

        when(repo.findById("A")).thenReturn(Optional.empty());
        when(repo.findById("B")).thenReturn(Optional.empty());

        MatchService service = new MatchService(repo);

        MatchRequest req = new MatchRequest();
        req.setPlayerAId("A");
        req.setPlayerAName("Gab");
        req.setPlayerBId("B");
        req.setPlayerBName("Lucas");
        req.setWinner("A");

        var resp = service.registerMatch(req);

        verify(repo, times(2)).save(any(Player.class));

        assertEquals(20, resp.getPlayerAPoints());
        assertEquals(0, resp.getPlayerBPoints());
    }
}
