package com.qa.playerbase.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import com.qa.playerbase.player.*;
import com.qa.playerbase.service.*;

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
public class PlayerController {
	
	private PlayerService service;
	
	@Autowired
	public PlayerController(PlayerService service) {
		this.service = service;
	}
	
	List<Player> players = new ArrayList<>();
	
	 @PostMapping("/create") //localhost:8080/player/create
	    public ResponseEntity<Player> create(@RequestBody Player player) {
	        return new ResponseEntity<Player>(service.create(player), HttpStatus.CREATED);	    }
	
	 @GetMapping("/getAll") //localhost:8080/player/getAll
	    public ResponseEntity<List<Player>> getAll() {
			return new ResponseEntity<List<Player>>(service.getAll(), HttpStatus.OK);
	    }
	 
	 @GetMapping("/getById/{id}") //localhost:8080/player/getById/id
	    public ResponseEntity<Player> getById(@PathVariable long id) {
			return new ResponseEntity<Player>(service.getById(id), HttpStatus.OK);
	    }
	 
	 @GetMapping("/getByUsername/{username}") //localhost:8080/player/getByUsername/username
	    public ResponseEntity<Player> getByUsername(@PathVariable String username) {
			return new ResponseEntity<Player>(service.getByUsername(username), HttpStatus.OK);
	    }
	 
	 @GetMapping("/getByEmail/{email}") //localhost:8080/player/getByEmail/email
	    public ResponseEntity<Player> geByEmail(@PathVariable String email) {
			return new ResponseEntity<Player>(service.getByEmail(email), HttpStatus.OK);
	    }
	 
	 @PutMapping("/update/{id}") //localhost:8080/player/update/id
	    public ResponseEntity<Player> update(@PathVariable long id, @RequestBody Player player) {
		 return new ResponseEntity<Player>(service.update(id, player), HttpStatus.ACCEPTED);
	    }
	 
	 @DeleteMapping("/delete/{id}") //localhost:8080/player/delete/id
	    public ResponseEntity<?> delete(@PathVariable long id) {
		 return (service.delete(id))? new ResponseEntity<>(HttpStatus.NO_CONTENT) :
			 new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	 
}
