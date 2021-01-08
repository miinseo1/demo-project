package com.aceproject.demo.config;

import static com.aceproject.gamebox.utils.stream.AceCollectors.*;
import static java.util.Optional.*;
import static java.util.stream.Collectors.*;

import java.util.Set;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.aceproject.gamebox.api.doc.component.PathBasedApiDocConfiguration;

@Configuration
public class DemoApiConfig {
	
	@Value("${gamebox.api.token-name}")
	private String tokenName;
	
	private static final String SVRAPI_PATTERN = "/svrpai/**";
	
	@Bean
	public PathBasedApiDocConfiguration demoApiDocConfiguration() {
		Set<String> excludePaths = Stream.of(SVRAPI_PATTERN).collect(toSet());

		return new PathBasedApiDocConfiguration(tokenName, excludePaths);
	}


}
