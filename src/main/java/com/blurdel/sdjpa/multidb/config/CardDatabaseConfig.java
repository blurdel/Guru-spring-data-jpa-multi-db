package com.blurdel.sdjpa.multidb.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CardDatabaseConfig {

	@Bean
	@ConfigurationProperties("spring.card.datasource")
	public DataSourceProperties cardDataSourceProperties() {
		return new DataSourceProperties();
	}
	
}
