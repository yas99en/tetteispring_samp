package com.example.config;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jndi.JndiTemplate;

// 8.2.6. プロファイルの指定 Springのプロファイル機能を使用したBean定義例(デフォルト)
@Configuration
@Profile("default") // デフォルト(開発者のローカル環境以外向け)のBean定義
public class DefaultContext {
	
    @Bean
    public DataSource dataSource() throws NamingException {
        JndiTemplate jndiTemplate = new JndiTemplate();
        return jndiTemplate.lookup("java:/comp/env/jdbc/dataSource", DataSource.class);
    }
    
}
