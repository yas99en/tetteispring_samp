package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

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
        		.requestMatchers(new AntPathRequestMatcher("/resources/**")).permitAll()
                .requestMatchers(new AntPathRequestMatcher("/")).permitAll()
                // 9.5.3.1. アクセスポリシーを適用するWebリソースの指定
                // 書籍では「"ACCOUNT_MANAGER"」というロールを使った例が記載されていますが、本実装では「"GENERAL"」「"ADMIN"」のロールを使用しています。
                .requestMatchers(new AntPathRequestMatcher("/general/**")).hasRole("GENERAL")
                .requestMatchers(new AntPathRequestMatcher("/admin/**")).hasRole("ADMIN")
                .anyRequest().authenticated()
        // 9.5.7.3 認可エラー時の遷移先 
        ).exceptionHandling((exceptionHandling) -> exceptionHandling
				// 以下の動作確認を行なう場合は「9.5.7.4 デフォルト動作のカスタマイズ」箇所をコメントアウトしてください。
        		// .accessDeniedPage("/WEB-INF/accessDeniedError.jsp") 
        		// 9.5.7.4 デフォルト動作のカスタマイズ
                .authenticationEntryPoint(myAuthenticationEntryPoint())
                .accessDeniedHandler(myAccessDeniedHandler())
        );
        
        return http.build();
    }

//  SpringBoot3では、以下のコードは不要。
//	@Autowired
//	public void configureAuthenticationManager(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(accountUserDetailsService).passwordEncoder(passwordEncoder());
//	}

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
