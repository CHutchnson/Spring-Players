package com.qa.playerbase.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import com.qa.playerbase.player.*;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@CrossOrigin
@RequestMapping("/player")
public class Controller {
	
	List<Player> players = new ArrayList<>();
	
	 @PostMapping("/create")
	    public boolean addPlayers(@RequestBody Player player) {
	        return this.players.add(player);
	    }
	
	 @GetMapping("/getAll")
	    public List<Player> getAllPlayers() {
			return this.players;
	        //
	    }
	 
	 @PutMapping("/update/{id}")
	    public Player updatePerson(@PathVariable int id, @RequestBody Player player) {
	        // Remove existing Person with matching 'id'
	        this.players.remove(id);
	        // Add new Person in its place
	        this.players.add(id, player);
	        return this.players.get(id);
	    }
	 
	 @DeleteMapping("/delete/{id}")
	    public Player removePerson(@PathVariable int id) {
	        // Remove Person and return it
	        return this.players.remove(id);
	    }
	 
}
