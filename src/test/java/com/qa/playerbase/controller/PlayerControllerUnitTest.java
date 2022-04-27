package com.qa.playerbase.controller;


import org.junit.jupiter.api.Test;

import static org.mockito.BDDMockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.playerbase.player.*;
import com.qa.playerbase.service.*;

@SpringBootTest//(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class PlayerControllerUnitTest {
	
	@Autowired
	private MockMvc mock;
	
	@Autowired
	private ObjectMapper jsonifier;
	
	@MockBean
	private PlayerService service;

	@Test
	void testcreate() throws Exception {
		 Player test = new Player("Lol", "Lol@gmail.com");
	    	
		 when(this.service.create(test)).thenReturn((test));
	    	
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
		 Player test = new Player("Lol", "Lol@gmail.com");
		 List<Player> result = new ArrayList<>();
		 result.add(test);
	    	
		 when(this.service.getAll()).thenReturn((result));
	    	
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
		 Player test = new Player("Lol", "Lol@gmail.com");
	    	
		 when(this.service.getById(1L)).thenReturn((test));
	    	
	     this.mock
	         .perform(get("/player/getById/1")
	             .accept(MediaType.APPLICATION_JSON)
	             .contentType(MediaType.APPLICATION_JSON)
	             .content(this.jsonifier.writeValueAsString(test)))
	         .andExpect(status().isOk())
	         .andExpect(content().json(this.jsonifier.writeValueAsString((test))));
	    }
	
	@Test
	void testgetByUsername() throws Exception {
		 Player test = new Player("Lol", "Lol@gmail.com");
	    	
		 when(this.service.getByUsername("Lol")).thenReturn((test));
	    	
	     this.mock
	         .perform(get("/player/getByUsername/Lol")
	             .accept(MediaType.APPLICATION_JSON)
	             .contentType(MediaType.APPLICATION_JSON)
	             .content(this.jsonifier.writeValueAsString(test)))
	         .andExpect(status().isOk())
	         .andExpect(content().json(this.jsonifier.writeValueAsString((test))));
	    }
	
	@Test
	void testgetByEmail() throws Exception {
		 Player test = new Player("Lol", "Lol@gmail.com");
	    	
		 when(this.service.getByEmail("Lol@gmail.com")).thenReturn((test));
	    	
	     this.mock
	         .perform(get("/player/getByEmail/Lol@gmail.com")
	             .accept(MediaType.APPLICATION_JSON)
	             .contentType(MediaType.APPLICATION_JSON)
	             .content(this.jsonifier.writeValueAsString(test)))
	         .andExpect(status().isOk())
	         .andExpect(content().json(this.jsonifier.writeValueAsString((test))));
	    }
	
	@Test
	void testupdate() throws Exception {
		 Player test = new Player("Lol", "Lol@gmail.com");
	    	
		 when(this.service.update(1L, test)).thenReturn((test));
	    	
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
		
		when(this.service.delete(1L)).thenReturn(true);
	    	
	     this.mock
	         .perform(delete("/player/delete/1")
	             .accept(MediaType.APPLICATION_JSON)
	             .contentType(MediaType.APPLICATION_JSON))
	         .andExpect(status().isNoContent());
	    }
	
	@Test
	void testdeleteFail() throws Exception {
		
		when(this.service.delete(2L)).thenReturn(false);
	    	
	     this.mock
	         .perform(delete("/player/delete/2")
	             .accept(MediaType.APPLICATION_JSON)
	             .contentType(MediaType.APPLICATION_JSON))
	         .andExpect(status().isInternalServerError());
	    }

}
