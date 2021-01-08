package com.aceproject.demo.dao.jdbc;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.aceproject.demo.dao.PlayerDao;
import com.aceproject.demo.model.Player;
import com.aceproject.demo.model.Stat;
import com.aceproject.gamebox.context.config.GameBoxApplication;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = PlayerDaoJdbcTest.class)
@GameBoxApplication
@Transactional
public class PlayerDaoJdbcTest {

	@Autowired
	private PlayerDao playerDao;

	@Test
	@Rollback(false)
	public void test_insert() throws Exception {

		Stat defaultStat = new Stat(1, 2, 3);

		List<Player> players = new ArrayList<>();
		players.add(new Player(1, "A", defaultStat));
		players.add(new Player(2, "B", defaultStat));
		players.add(new Player(3, "C", defaultStat));
		players.add(new Player(4, "D", defaultStat));
		players.add(new Player(5, "E", defaultStat));

		playerDao.insert(players);

		int playerId = 1;
		Player player = playerDao.get(playerId);
		
		assertEquals(playerId, player.getPlayerId());
	}
}
