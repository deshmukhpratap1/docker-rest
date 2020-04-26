package com.levo.dockerexample.config;

import java.lang.reflect.InvocationTargetException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})

public class DbConfig {

	@Value("${spring.datasource.url}")
	private String jdbcUrl;
	@Value("${spring.datasource.driverClassName}")
	private String driverClassName;
	@Value("${spring.datasource.username}")
	private String username;
	@Value("${spring.datasource.password}")
	private String password;
	
	@Bean
	JdbcTemplate jdbcTemplate() throws IllegalAccessException, InvocationTargetException, InstantiationException {
		System.out.println("-----Configuring JDBCTemplate------");
		HikariConfig config = new HikariConfig();
		config.setDriverClassName(driverClassName);
		// config.setDataSourceProperties(properties);
		config.setJdbcUrl(jdbcUrl);
		config.setUsername(username);
		config.setPassword(password);
		HikariDataSource ds = new HikariDataSource(config);
		return new JdbcTemplate(ds);
	}
}
