package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.domain.service.account.AccountUserDetailsService;

//9.3.2.3. Java ConfigによるBean定義例
@Configuration 
@EnableWebSecurity
@Import({WebMvcConfig.class, AppConfig.class})
public class WebSecurityConfig {
	
	private AccountUserDetailsService accountUserDetailsService;
	
	public WebSecurityConfig(AccountUserDetailsService accountUserDetailsService) {
		this.accountUserDetailsService = accountUserDetailsService;
	}
	
    @Bean
    @Order(1)
    public SecurityFilterChain uiSecurityFilterChain(HttpSecurity http) throws Exception {
        http.securityMatcher("/ui/**")
        .formLogin(login -> login
                .loginProcessingUrl("/ui/login") // ログインURL
                .loginPage("/ui/login") // ログインフォームを表示するためのパス
                .defaultSuccessUrl("/ui/menu") // 認証成功時のURLのデフォルト
                .failureUrl("/ui/login?error") // 認証失敗時のURL
                .permitAll()
        ).authorizeHttpRequests(authz -> authz
                .anyRequest().authenticated()
        );
        return http.build();
    }
    
	@Bean
    @Order(2)
    public SecurityFilterChain apiSecurityFilterChain(HttpSecurity http) throws Exception {
       http
       	.securityMatcher("/api/**")    
       	.authorizeHttpRequests(authorize -> authorize
    			.anyRequest().authenticated()
    	)
		.httpBasic(Customizer.withDefaults());
        return http.build();
    }

    
    @Autowired
    public void configureAuthenticationManager(AuthenticationManagerBuilder auth) throws Exception {
    	auth.userDetailsService(accountUserDetailsService).passwordEncoder(passwordEncoder());
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
