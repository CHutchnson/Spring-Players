package com.qa.playerbase.player;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Player {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private long id;

	    @Column(unique = true, nullable = false)
	    private String username;
	    
	    @Column(unique = true, nullable = false)
	    private String email;
}
