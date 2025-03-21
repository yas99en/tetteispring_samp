package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
public class TestConfig {
	
	// 8.3.1. テスト用のデータソースの設定 テスト用のデータソースの定義例
	@Bean // 通常使用するデータソースのBean名と同じ名前でBean定義
	public EmbeddedDatabase dataSource() {
		return new EmbeddedDatabaseBuilder()
				.setType(EmbeddedDatabaseType.H2)
				.setScriptEncoding("UTF-8").addScript("schema.sql")
				.build();
	}

	// 8.3.4. テーブルの中身の検証 JdbcTemplateの定義例
	@Bean
	public JdbcTemplate jdbcTemplateForAssertion(EmbeddedDatabase dataSource) {
		return new JdbcTemplate(dataSource);
	}

}
