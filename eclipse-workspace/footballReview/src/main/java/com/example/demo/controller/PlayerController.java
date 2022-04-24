package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Player;
import com.example.demo.repository.PlayerRepository;

import exception.ResourceNotFoundException;

@RestController
@RequestMapping("/Player")
public class PlayerController {

	@Autowired
	private PlayerRepository playerRepository;

	@GetMapping("/Player/player")
	public List<Player> getPlayers() {
		return this.playerRepository.findAll();
	}

	@GetMapping("/{id}")
	public Player getPlayerById(@PathVariable(value = "id") long playerId) {

		return this.playerRepository.findById(playerId)
				.orElseThrow(() -> new ResourceNotFoundException("Player not found with id :" + playerId));
	}

	@PostMapping
	public Player createPlayer(@RequestBody PlayerController junit) {
		return this.playerRepository.saveAll(junit);

	}

	@PutMapping("/{id}")
	public Player updateUser(@RequestBody Player user, @PathVariable("id") long userId) {
		Player existingUser = this.playerRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("user not found with id :" + userId));

		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
		existingUser.setNationality(user.getNationality());
		return this.playerRepository.save(existingUser);

	}

}
