package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@Import({ WebMvcConfig.class, AppConfig.class })
public class WebSecurityConfig {

//	private AccountUserDetailsService accountUserDetailsService;

	public WebSecurityConfig() {
	}

//	@Autowired
//	public WebSecurityConfig(AccountUserDetailsService accountUserDetailsService) {
//		this.accountUserDetailsService = accountUserDetailsService;
//	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.formLogin(login -> login.loginPage("/login")
				// 9.4.2.4. デフォルト動作のカスタマイズ
				.loginProcessingUrl("/authenticate") // 認証パスの変更
				.usernameParameter("uid") // ユーザー名のリクエストパラメータの変更
				.passwordParameter("pwd") // パスワードのリクエストパラメータの変更
				// 9.4.3.2. デフォルト動作のカスタマイズ
				.defaultSuccessUrl("/menu") // 認証成功した際に遷移するデフォルトパスの変更
				// 9.4.4.2. デフォルト動作のカスタマイズ
				.failureUrl("/loginFailure") // 認証失敗時に遷移するパスの変更
				.permitAll()).authorizeHttpRequests(authz -> authz.anyRequest().authenticated());

		http.logout(logout -> logout // ログアウト機能を有効にする
				// 9.4.8.3. デフォルト動作のカスタマイズ
				.logoutUrl("/auth/logout") // ログアウトパスの変更
				// 9.4.9.2. デフォルト動作のカスタマイズ
				.logoutSuccessUrl("/logoutSuccess") // ログアウト成功時に遷移するパスの変更
				.permitAll());
		return http.build();
	}

//  Spring Security 5.7以降は、AuthenticationManagerBuilderを直接使用しないため、以下のコードはコメントアウトしています。
//	// AuthenticationManagerのBean定義を行なうためのメソッド
//	@Autowired
//	public void configureAuthenticationManager(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(accountUserDetailsService) // DaoAuthenticationProviderを有効化
//				.passwordEncoder(passwordEncoder()); // DaoAuthenticationProviderにPasswordEncoderを設定
//	}
//
	@Bean
	public PasswordEncoder passwordEncoder() {
		// パスワードをBCryptアルゴリズムを使用してハッシュ化
		return new BCryptPasswordEncoder();
	}
}
