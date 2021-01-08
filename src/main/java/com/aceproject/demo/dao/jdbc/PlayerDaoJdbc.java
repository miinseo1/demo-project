package com.aceproject.demo.dao.jdbc;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.aceproject.demo.dao.PlayerDao;
import com.aceproject.demo.model.Player;
import com.aceproject.demo.support.DemoDataDaoJdbcSupport;

@Repository
public class PlayerDaoJdbc extends DemoDataDaoJdbcSupport<Player> implements PlayerDao {

	@Override
	public void insert(Player player) {
		insertOne(player);
	}

	@Override
	public void insert(List<Player> players) {
		insertList(players);
	}

	@Override
	public Player get(int playerId) {
		return selectOne(playerId);
	}

}