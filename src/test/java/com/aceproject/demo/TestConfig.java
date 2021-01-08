package com.aceproject.demo;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class TestConfig {

	@Bean
	public JdbcTemplate jdbcTemplateData(@Qualifier("dataSource_data") DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

	@Bean
	public JdbcTemplate jdbcTemplateLog(@Qualifier("dataSource_log") DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

}
