package org.example.configuration;

import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;

// 3.3.1.2.1. 基本的な設定方法
// (1)
@Configuration
@EnableTransactionManagement
@ComponentScan("org.example") // for this example only
public class TransactionManagerConfig {

	// (2)
	@Bean
	public PlatformTransactionManager transactionManager(DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}

	// 3.3.3.2.2. Bean定義
	// (1)
	@Bean
	public TransactionTemplate transactionTemplate(PlatformTransactionManager transactionManager) {
		// (2)
		TransactionTemplate transactionTemplate = new TransactionTemplate(transactionManager);
		// (3)
		transactionTemplate.setIsolationLevel(TransactionDefinition.ISOLATION_READ_COMMITTED);
		transactionTemplate.setTimeout(30);
		return transactionTemplate;
	}

	// for this example only
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
}