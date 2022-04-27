package com.qa.playerbase.controller;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.playerbase.player.*;

@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:player-schema.sql",
		"classpath:player-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
class PlayerControllerIntegrationTest {

	@Autowired
	private MockMvc mock;

	@Autowired
	private ObjectMapper jsonifier;
	
	@Test
	void testcreate() throws Exception {
		 Player test = new Player(4L, "Lol", "Lol@gmail.com");
	    	
	     this.mock
	         .perform(post("/player/create")
	             .accept(MediaType.APPLICATION_JSON)
	             .contentType(MediaType.APPLICATION_JSON)
	             .content(this.jsonifier.writeValueAsString(test)))
	         .andExpect(status().isCreated())
	         .andExpect(content().json(this.jsonifier.writeValueAsString((test))));
	    }
	
	@Test
	void testgetAll() throws Exception {
		Player test = new Player(1L, "Feral", "Feral@gmail.com");
		Player test2 = new Player(2L, "Kappa", "Kappa@gmail.com");
		Player test3 = new Player(3L, "Soul", "Soul@gmail.com");
		 List<Player> result = new ArrayList<>();
		 result.add(test);
		 result.add(test2);
		 result.add(test3);
	    	
	     this.mock
	         .perform(get("/player/getAll")
	             .accept(MediaType.APPLICATION_JSON)
	             .contentType(MediaType.APPLICATION_JSON)
	             .content(this.jsonifier.writeValueAsString(result)))
	         .andExpect(status().isOk())
	         .andExpect(content().json(this.jsonifier.writeValueAsString((result))));
	    }
	
	@Test
	void testgetById() throws Exception {
		Player test = new Player(1L, "Feral", "Feral@gmail.com");
	    	
	     this.mock
	         .perform(get("/player/getById/1")
	             .accept(MediaType.APPLICATION_JSON)
	             .contentType(MediaType.APPLICATION_JSON))
	         .andExpect(status().isOk())
	         .andExpect(content().json(this.jsonifier.writeValueAsString(test)));
	    }
	
	@Test
	void testgetByUsername() throws Exception {
		Player test = new Player(1L, "Feral", "Feral@gmail.com");
	    	
	     this.mock
	         .perform(get("/player/getByUsername/Feral")
	             .accept(MediaType.APPLICATION_JSON)
	             .contentType(MediaType.APPLICATION_JSON)
	             .content(this.jsonifier.writeValueAsString(test)))
	         .andExpect(status().isOk())
	         .andExpect(content().json(this.jsonifier.writeValueAsString((test))));
	    }
	
	@Test
	void testgetByEmail() throws Exception {
		Player test = new Player(1L, "Feral", "Feral@gmail.com");
	    	
	     this.mock
	         .perform(get("/player/getByEmail/Feral@gmail.com")
	             .accept(MediaType.APPLICATION_JSON)
	             .contentType(MediaType.APPLICATION_JSON)
	             .content(this.jsonifier.writeValueAsString(test)))
	         .andExpect(status().isOk())
	         .andExpect(content().json(this.jsonifier.writeValueAsString((test))));
	    }
	
	@Test
	void testupdate() throws Exception {
		Player test = new Player(1L, "Feral", "Feral@gmail.com");
		 
	     this.mock
	         .perform(put("/player/update/1")
	             .accept(MediaType.APPLICATION_JSON)
	             .contentType(MediaType.APPLICATION_JSON)
	             .content(this.jsonifier.writeValueAsString(test)))
	         .andExpect(status().isAccepted())
	         .andExpect(content().json(this.jsonifier.writeValueAsString((test))));
	    }
	
	@Test
	void testdelete() throws Exception {
	    	
	     this.mock
	         .perform(delete("/player/delete/1")
	             .accept(MediaType.APPLICATION_JSON)
	             .contentType(MediaType.APPLICATION_JSON))
	         .andExpect(status().isNoContent());
	    }

}









