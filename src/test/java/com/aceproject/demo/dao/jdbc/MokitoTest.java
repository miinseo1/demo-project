package com.aceproject.demo.dao.jdbc;

import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import org.hamcrest.core.Is;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.aceproject.demo.dao.PlayerDao;
import com.aceproject.demo.model.Player;
import com.aceproject.demo.model.Stat;
import com.aceproject.gamebox.context.config.GameBoxApplication;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = MokitoTest.class)
@GameBoxApplication
@Transactional
public class MokitoTest {
	
	@Mock
	private PlayerDao playerDao;
	
	Stat defaultStat = new Stat(1, 2, 3);
	
	@Test
	@Rollback()
	public void mokito_test() {
		
		when(playerDao.get(anyInt())).then(invocation -> {
			int id = (int) invocation.getArguments()[0];
			return new Player(id, "D", defaultStat);
		});
		
				
		int playerId = 5;
		
		final Player player = playerDao.get(playerId);
		
		assertThat(player.getPlayerId(), Is.is(playerId));
	}

}
