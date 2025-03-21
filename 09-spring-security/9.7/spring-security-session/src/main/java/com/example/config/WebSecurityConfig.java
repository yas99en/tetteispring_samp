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
import org.springframework.security.config.http.SessionCreationPolicy;
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
@Import({ WebMvcConfig.class, AppConfig.class })
public class WebSecurityConfig {

	private AccountUserDetailsService accountUserDetailsService;

	@Autowired
	public WebSecurityConfig(AccountUserDetailsService accountUserDetailsService) {
		this.accountUserDetailsService = accountUserDetailsService;
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.formLogin(login -> login.loginProcessingUrl("/login").loginPage("/login").defaultSuccessUrl("/menu")
				.failureUrl("/login?error").permitAll())
				.logout(logout -> logout.logoutSuccessUrl("/logout").permitAll())
				.authorizeHttpRequests(authz -> authz.antMatchers("/resources/**").permitAll().antMatchers("/")
						.permitAll().antMatchers("/general/**").hasRole("GENERAL").antMatchers("/admin/**")
						.hasRole("ADMIN").antMatchers("/admin/**").access((authentication, context) -> {
							IpAddressMatcher ipAddressMatcher = new IpAddressMatcher("127.0.0.1");
							HttpServletRequest request = context.getRequest();
							return new AuthorizationDecision(ipAddressMatcher.matches(request));
						}).anyRequest().authenticated())
				.exceptionHandling((exceptionHandling) -> exceptionHandling.accessDeniedHandler(myAccessDeniedHandler())
						.authenticationEntryPoint(myAuthenticationEntryPoint())
				// 9.7.1 セッション管理機能の適用
				).sessionManagement(session -> session
						// 9.7.1 セッションの作成方針を"stateless"に指定
//						.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
						// 9.7.1 メモの検証
						// 動作確認を行なう場合は、「9.7.3 セッション固定攻撃対策機能」の箇所をコメントアウトしてください。
//						.sessionFixation().none()
						// 9.7.3 セッション固定攻撃対策機能
						// 動作確認を行なう場合は、「9.7.1 セッションの作成方針を"stateless"に指定」、「9.7.1 メモの検証」の箇所をコメントアウトしてください。
//						.sessionFixation().newSession()
						// 9.7.5 無効なセッションを使ったリクエストの検知
						// 動作確認を行なう場合は、「9.7.1 セッションの作成方針を"stateless"に指定」、「9.7.1 メモの検証」の箇所をコメントアウトしてください。
						// web.xmlにて、タイムアウト値(分単位)を1分に設定しています。
						.invalidSessionUrl("/logout")
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
