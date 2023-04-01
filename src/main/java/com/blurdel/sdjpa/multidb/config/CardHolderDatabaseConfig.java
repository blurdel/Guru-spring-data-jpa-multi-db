package com.blurdel.sdjpa.multidb.config;

import com.blurdel.sdjpa.multidb.domain.cardholder.CreditCardHolder;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;

@Configuration
public class CardHolderDatabaseConfig {

	@Bean
	@ConfigurationProperties("spring.cardholder.datasource")
	public DataSourceProperties cardHolderDataSourceProperties() {
		return new DataSourceProperties();
	}

	@Bean
	public DataSource cardHolderDataSource(@Qualifier("cardHolderDataSourceProperties") DataSourceProperties cardHolderDataSourceProperties) {
		return cardHolderDataSourceProperties.initializeDataSourceBuilder()
				.type(HikariDataSource.class)
				.build();
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean cardHolderEntityManagerFactory(
			@Qualifier("cardHolderDataSource") DataSource cardHolderDataSource, EntityManagerFactoryBuilder builder) {

		return builder.dataSource(cardHolderDataSource)
				.packages(CreditCardHolder.class)
				.persistenceUnit("cardholder")
				.build();
	}
}
