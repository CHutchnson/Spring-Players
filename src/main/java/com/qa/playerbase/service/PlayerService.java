package com.qa.playerbase.service;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import com.qa.playerbase.player.*;

@Service
public class PlayerService {
	
	private List<Player> players = new ArrayList<>();

    public Player addlayer(Player player) {
        // Add new Person
        this.players.add(player);
        // Return last added Person from List
        return this.players.get(this.players.size() - 1);
    }

    public List<Player> getAllPlayer() {
        // Return the whole List
        return this.players;
    }

    public Player updatePlayer(int id, Player player) {
        // Remove existing Person with matching 'id'
        this.players.remove(id);
        // Add new Person in its place
        this.players.add(id, player);
        // Return updated Person from List
        return this.players.get(id);
    }

    public Player removePlayer(int id) {
        // Remove Person and return it
        return this.players.remove(id);
    }

}


