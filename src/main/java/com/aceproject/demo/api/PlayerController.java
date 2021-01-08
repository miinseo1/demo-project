package com.aceproject.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aceproject.demo.model.Player;
import com.aceproject.demo.service.PlayerService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/players")
@Slf4j
public class PlayerController {

	@Autowired
	private PlayerService playerService;

	/**
	 * test : curl localhost:8080/demo/api/players/{playerId}
	 * 
	 * @param playerId
	 * @return
	 */
	@GetMapping("/{playerId}")
	public Player get(@PathVariable("playerId") int playerId) {
		log.debug("@@@@@@@ playerId : {}", playerId);

		return playerService.getPlayer(playerId);
	}

}