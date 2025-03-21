package org.example;

import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * 3.2.2限定で利用するConfig
 * 
 * 3.2.2.9. テーブルを更新する処理(Insert、Update、Delete)の動作検証のために@EnableTransactionManagementアノテーションを使用してます。
 * @EnableTransactionManagementアノテーションについては3.3章以降で説明します
 */
@Configuration
@EnableTransactionManagement
@ComponentScan("org.example")
public class AppConfig {
    // omitted

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }

    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}