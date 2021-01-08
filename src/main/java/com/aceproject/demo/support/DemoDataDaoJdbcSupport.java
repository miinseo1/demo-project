package com.aceproject.demo.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;

import com.aceproject.gamebox.orm.AbstractEntityDao;

public abstract class DemoDataDaoJdbcSupport<T> extends AbstractEntityDao<T> {
	@Autowired
	@Qualifier("jdbcTemplateData")
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
