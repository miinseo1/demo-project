package com.aceproject.demo.dao;

import java.util.List;

import com.aceproject.demo.model.Player;

public interface PlayerDao {

	void insert(Player player);

	void insert(List<Player> players);

	Player get(int playerId);

}
