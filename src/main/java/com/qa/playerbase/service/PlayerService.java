package com.qa.playerbase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.qa.playerbase.exception.PlayerNotFoundException;
import com.qa.playerbase.player.*;
import com.qa.playerbase.repository.*;

@Service
public class PlayerService {
	
	private PlayerRepo repo;
	
	@Autowired
	public PlayerService(PlayerRepo repo) {
		this.repo = repo;
	}

	//create
    public Player create(Player player) {
        return repo.saveAndFlush(player);
    }
    
	//get all
	public List<Player> getAll() {
		return repo.findAll();
	}
	
	//get id
	public Player getById(long id) {
		return repo.findById(id).orElseThrow(PlayerNotFoundException::new);
	}
    
	//get user-name
	public Player getByUsername(String username) {
		return repo.findByUsername(username).orElseThrow(PlayerNotFoundException::new);
	}
	
	//get email
	public Player getByEmail(String email) {
		return repo.findByEmail(email).orElseThrow(PlayerNotFoundException::new);
	}
	
    //update
    public Player update(long id, Player player) {
        Player existing = repo.findById(id).get();
        existing.setUsername(player.getUsername());
        existing.setEmail(player.getEmail());
        return repo.saveAndFlush(existing);
        
    }

    //delete
    public boolean delete(long id) {
        repo.deleteById(id);
        return !repo.existsById(id);
    }

}


