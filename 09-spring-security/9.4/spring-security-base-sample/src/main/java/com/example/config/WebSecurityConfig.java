package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.domain.service.account.AccountUserDetailsService;

@Configuration
@EnableWebSecurity // 9.4.11. 認証処理とSpring MVCの連携
@Import({ WebMvcConfig.class, AppConfig.class })
public class WebSecurityConfig {

	// 9.4.5.3. 認証処理の適用
	private AccountUserDetailsService accountUserDetailsService;

	@Autowired
	public WebSecurityConfig(AccountUserDetailsService accountUserDetailsService) {
		this.accountUserDetailsService = accountUserDetailsService;
	}

	// 9.4.2.3. ログインフォームの作成
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.formLogin(login -> login.loginPage("/login") // ログインフォームを表示するためのパスを指定
				.defaultSuccessUrl("/menu") // 9.4.3.2. デフォルト動作のカスタマイズ
				.permitAll() // すべてのユーザーに対してログインフォームへのアクセス権を付与
		).authorizeHttpRequests(authz -> authz // Webリソースに対してアクセスポリシーを指定
				.anyRequest().authenticated());

		// 9.4.8.1. ログアウト処理の適用
		http.logout(logout -> logout // ログアウト機能を有効にする
				.permitAll() // 匿名ユーザーを含むすべてのユーザーに対してログアウトとログアウト成功時に遷移するパスへのアクセス権を付与
		);
		return http.build();
	}

	// 9.4.5.3. 認証処理の適用
	// AuthenticationManagerのBean定義を行なうためのメソッド
	@Autowired
	public void configureAuthenticationManager(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(accountUserDetailsService) // DaoAuthenticationProviderを有効化
				.passwordEncoder(passwordEncoder()); // DaoAuthenticationProviderにPasswordEncoderを設定
	}

	// 9.4.6. パスワードのハッシュ化
	@Bean
	public PasswordEncoder passwordEncoder() {
		// パスワードをBCryptアルゴリズムを使用してハッシュ化
		return new BCryptPasswordEncoder();
	}
}
