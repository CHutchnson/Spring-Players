package com.qa.playerbase.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.qa.playerbase.player.*;

@Repository
public interface PlayerRepo extends JpaRepository<Player, Long>  {
	
	//Custom query methods
	Optional<Player> findByUsername(String username);
	Optional<Player> findByEmail(String email);

}
