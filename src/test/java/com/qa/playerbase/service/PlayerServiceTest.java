package com.qa.playerbase.service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.qa.playerbase.player.*;
import com.qa.playerbase.repository.PlayerRepo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Optional;

@SpringBootTest
class PlayerServiceTest {
	
	@Autowired
	private PlayerService service;
	
	@MockBean
	private PlayerRepo repo;

	@Test
	void testCreate() {
		Player test = new Player("Lol", "Lol@gmail.com" );		
		Player test2 = new Player(1L, "Lol", "Lol@gmail.com");
		when(this.repo.saveAndFlush(test)).thenReturn(test2);
		assertEquals(test2, service.create(test));
		verify(repo, times(1)).saveAndFlush(test);
		
		
	}
	
	@Test
	void testGetAll() {
		when(repo.findAll()).thenReturn(new ArrayList<>());
		assertThat(service.getAll()).isEqualTo(new ArrayList<>());
		verify(repo, times(1)).findAll();
	    }

	 @Test
	 void testGetById() {
		 Player test = new Player(1L, "Lol", "Lol@gmail.com" );	
		 Optional<Player> option = Optional.of(test);
		 Player existing = option.get();
		 when(repo.findById((long) 1)).thenReturn(option);
		 assertThat(service.getById(1)).isEqualTo((existing));
		 verify(repo, times(1)).findById((long) 1);
		}
	 
	 @Test
	 void testGetByUsername() {
		Optional<Player> OptionalOutput = Optional.of(new Player(1L, "Lol", "Lol@gmail.com"));
		Player output = new Player (1L, "Lol", "Lol@gmail.com");
		when(repo.findByUsername("Lol")).thenReturn(OptionalOutput);
		assertEquals(output, service.getByUsername("Lol"));
		verify(repo, times(1)).findByUsername("Lol");
		}
	 
	 @Test
	 void testGetByEmail() {
		Optional<Player> OptionalOutput = Optional.of(new Player(1L, "Lol", "Lol@gmail.com"));
		Player output = new Player (1L, "Lol", "Lol@gmail.com");
		when(repo.findByEmail("Lol@gmail.com")).thenReturn(OptionalOutput);
		assertEquals(output, service.getByEmail("Lol@gmail.com"));
		verify(repo, times(1)).findByEmail("Lol@gmail.com");
		}

	 @Test
	 void testUpdate() {
		 Player input = new Player("lol", "lol@gmail.com");
		Optional<Player> existing = Optional.of(new Player(1L, "lmao", "lmao@gmail.com"));
		Player output = new Player(1L, "lol", "lol@gmail.com");
		 when(repo.findById((long) 1)).thenReturn(existing);
		 when(repo.saveAndFlush(output)).thenReturn(output);
		 
		 assertEquals(output, this.service.update(1L, input));
		 verify(repo, times(1)).findById(1L);
		 verify(repo, times(1)).saveAndFlush(output);
	    }

	 @Test
	 void testDeleteById() {
		 when(repo.existsById((1L))).thenReturn(false);
		 assertTrue(this.service.delete(1L));
		 verify(repo, times(1)).deleteById((long) 1);
		 verify(repo, times(1)).existsById((long) 1);
	    }

}
