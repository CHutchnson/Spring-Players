package com.qa.playerbase.service;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import com.qa.playerbase.player.*;

@Service
public class PlayerService {
	
	private List<Player> players = new ArrayList<>();

    public Player addlayer(Player player) {
        this.players.add(player);
        return this.players.get(this.players.size() - 1);
    }

    public List<Player> getAllPlayers() {
        return this.players;
    }

    public Player updatePlayer(int id, Player player) {
        this.players.remove(id);
        this.players.add(id, player);
        return this.players.get(id);
    }

    public Player removePlayer(int id) {
        return this.players.remove(id);
    }

}


