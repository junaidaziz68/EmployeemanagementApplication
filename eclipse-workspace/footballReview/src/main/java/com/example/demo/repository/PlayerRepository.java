package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.controller.PlayerController;
import com.example.demo.entity.Player;

public interface PlayerRepository extends JpaRepository<Player, Long> {

	Player saveAll(PlayerController junit);

	List<Player> getAll();

	@Override
	List<Player> findAll();

}
