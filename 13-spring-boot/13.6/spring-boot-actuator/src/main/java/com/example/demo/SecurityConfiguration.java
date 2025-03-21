package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
	// 13.6.4. セキュリティの有効化 エンドポイントに対する認可制御をカスタマイズする設定例
	@Bean
	public SecurityFilterChain actuatorSecurityFilter(HttpSecurity http) throws Exception {
		http
			.requestMatcher(EndpointRequest.toAnyEndpoint())
			.authorizeRequests(requests -> requests
				// 13.6.4.の動作確認を実施する場合はhasRole行のコメントアウトを外し、permitAll行をコメントアウトしてください
//				.anyRequest().hasRole("ENDPOINT_ADMIN")
				.anyRequest().permitAll()
			)
			// 13.6.1.のshutdown（POST）の動作確認用にCSRF保護を無効化
			// Spring Securityを有効にした場合、POSTメソッド実行時にCSRFトークンチェックが実行されてエラーとなるため
			.csrf(csrf -> csrf.disable())
			.httpBasic();
		return http.build();
	}
	
	@Autowired
	public void configureAuthenticationManager(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("user").password("{noop}user").roles("USER")
			.and()
			.withUser("system").password("{noop}system").roles("ENDPOINT_ADMIN");
	}
}
