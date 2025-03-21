package com.example.config;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.util.matcher.IpAddressMatcher;

import com.example.domain.service.account.AccountUserDetailsService;
import com.example.security.MyAccessDeniedHandler;
import com.example.security.MyAuthenticationEntryPoint;

@Configuration 
@EnableWebSecurity
@Import({WebMvcConfig.class, AppConfig.class})
public class WebSecurityConfig {

	private AccountUserDetailsService accountUserDetailsService;

	@Autowired
	public WebSecurityConfig(AccountUserDetailsService accountUserDetailsService) {
		this.accountUserDetailsService = accountUserDetailsService;
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.formLogin(login -> login
				.loginProcessingUrl("/login")
				.loginPage("/login")
				.defaultSuccessUrl("/menu")
				.failureUrl("/login?error")
				.permitAll()
		).logout(logout -> logout
				.logoutSuccessUrl("/logout").permitAll() 
		).authorizeHttpRequests(authz -> authz
				.antMatchers("/resources/**").permitAll()
				.antMatchers("/").permitAll()
				.antMatchers("/general/**").hasRole("GENERAL")
				.antMatchers("/admin/**").hasRole("ADMIN")
				.antMatchers("/admin/**").access((authentication, context) -> {
					IpAddressMatcher ipAddressMatcher = new IpAddressMatcher("127.0.0.1");
					HttpServletRequest request = context.getRequest();
					return new AuthorizationDecision(ipAddressMatcher.matches(request));
				})
				.anyRequest().authenticated()
		).exceptionHandling((exceptionHandling) -> exceptionHandling
				.accessDeniedHandler(myAccessDeniedHandler())
				.authenticationEntryPoint(myAuthenticationEntryPoint())
		).sessionManagement(session -> session
				.sessionFixation().newSession()
		).headers(headers -> headers
				// 9.8.1. セキュリティヘッダー出力機能の適用 Java Configによる無効化例
				// .disable() // disableメソッドを呼び出し無効化
				// 9.8.3. セキュリティヘッダーの選択 Java ConfigによるBean定義例
				// .defaultsDisabled()
				// .cacheControl().and()
				// .frameOptions().and()
				// .contentTypeOptions().and()
				// .xssProtection().and()
				// .httpStrictTransportSecurity()
				// 9.8.3 セキュリティヘッダーの選択 Java ConfigによるBean定義例(不要なものだけ無効化する例)
				.cacheControl().disable() // disableメソッドを呼び出し無効化
		);
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

	@Bean
	public AuthenticationEntryPoint myAuthenticationEntryPoint() {
		return new MyAuthenticationEntryPoint();
	}

	@Bean
	public AccessDeniedHandler myAccessDeniedHandler() {
		return new MyAccessDeniedHandler();
	}
}
