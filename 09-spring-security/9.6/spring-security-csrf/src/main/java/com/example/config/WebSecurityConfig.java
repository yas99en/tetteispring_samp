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
@Import({WebMvcConfig.class, AppConfig.class})
public class WebSecurityConfig {
	
//	private AccountUserDetailsService accountUserDetailsService;
//	
//	public WebSecurityConfig(AccountUserDetailsService accountUserDetailsService) {
//		this.accountUserDetailsService = accountUserDetailsService;
//	}

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
        		.requestMatchers("/resources/**").permitAll()
        		.requestMatchers("/static/**").permitAll()
        		.requestMatchers("/api/**").permitAll() // AJAXのCSRF検証の為、APIへのアクセスを許可
                .requestMatchers("/").permitAll()
                .requestMatchers("/general/**").hasRole("GENERAL")
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated()
        // 9.6.2. CSRF対策機能の適用
        // CSRF対策機能はデフォルトで有効となっています。
        // 無効にしたい場合は、下記のコメントアウトを外してください。
//        ).csrf(csrf -> csrf.disable()
        );

        
        return http.build();
    }

    // SpringBoot3では不要
//    @Autowired
//    public void configureAuthenticationManager(AuthenticationManagerBuilder auth) throws Exception {
//    	auth.userDetailsService(accountUserDetailsService).passwordEncoder(passwordEncoder());
//    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
