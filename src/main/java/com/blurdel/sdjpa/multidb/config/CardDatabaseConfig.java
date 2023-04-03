package com.blurdel.sdjpa.multidb.config;

import com.blurdel.sdjpa.multidb.domain.creditcard.CreditCard;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;

@EnableJpaRepositories(basePackages = "com.blurdel.sdjpa.multidb.repositories.creditcard",
		entityManagerFactoryRef = "cardEntityManagerFactory", transactionManagerRef = "cardTransactionManager")
@Configuration
public class CardDatabaseConfig {

	@Bean
	@ConfigurationProperties("spring.card.datasource")
	public DataSourceProperties cardDataSourceProperties() {
		return new DataSourceProperties();
	}

	@Bean
	@ConfigurationProperties("spring.card.datasource.hikari")
	public DataSource cardDataSource(@Qualifier("cardDataSourceProperties") DataSourceProperties cardDataSourceProperties) {
		return cardDataSourceProperties.initializeDataSourceBuilder()
				.type(HikariDataSource.class)
				.build();
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean cardEntityManagerFactory(
			@Qualifier("cardDataSource") DataSource cardDataSource, EntityManagerFactoryBuilder builder) {

		Properties props = new Properties();
		props.put("hibernate.hbm2ddl.auto", "validate");
		props.put("hibernate.physical_naming_strategy", "org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy");

		LocalContainerEntityManagerFactoryBean efb =
				builder.dataSource(cardDataSource)
				.packages(CreditCard.class)
				.persistenceUnit("card")
				.build();

		efb.setJpaProperties(props);

		return efb;
	}

	@Bean
	public PlatformTransactionManager cardTransactionManager(
			@Qualifier("cardEntityManagerFactory") LocalContainerEntityManagerFactoryBean cardEntityManagerFactory) {

		return new JpaTransactionManager(cardEntityManagerFactory.getObject());
	}
}
