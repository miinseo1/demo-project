package com.aceproject.demo.config;

import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;

@Configuration
public class DemoConfig {

	@Bean
	public PropertiesFactoryBean configProperties() {
		PropertiesFactoryBean factory = new PropertiesFactoryBean();
		factory.setLocation(new ClassPathResource("config.properties"));

		return factory;
	}

	/**
	 * spring-boot의 자동등록시 objectMapper 인젝트 관련 발생하는 문제 방지를 위해 빈걸로 생성
	 *
	 * @return
	 */
	@Bean
	public ObjectMapper objectMapper() {
		return Jackson2ObjectMapperBuilder.json().modules(new JodaModule()).build();
	}

}