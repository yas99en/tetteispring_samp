package com.example.config;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.IpAddressMatcher;

@Configuration 
@EnableWebSecurity
@Import({WebMvcConfig.class, AppConfig.class})
public class WebSecurityConfig {
	
//	private AccountUserDetailsService accountUserDetailsService;
//
//	public WebSecurityConfig(AccountUserDetailsService accountUserDetailsService) {
//		this.accountUserDetailsService = accountUserDetailsService;
//	}

	public WebSecurityConfig() {
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
                .requestMatchers(new AntPathRequestMatcher("/accounts/**")).permitAll()
                .requestMatchers(new AntPathRequestMatcher("/")).permitAll()
                .requestMatchers(new AntPathRequestMatcher("/general/**")).hasRole("GENERAL")
                .requestMatchers(new AntPathRequestMatcher("/admin/**")).hasRole("ADMIN")
                .requestMatchers(new AntPathRequestMatcher("/admin/**")).access((authentication, context) -> {
                	IpAddressMatcher ipAddressMatcher = new IpAddressMatcher("127.0.0.1");
                	HttpServletRequest request = context.getRequest();
                	return new AuthorizationDecision(ipAddressMatcher.matches(request));
                })
                .anyRequest().authenticated()
        ).sessionManagement(session -> session
                .sessionFixation().newSession()
                .invalidSessionUrl("/logout")
        		);
        
        return http.build();
    }

//  springboot3 では以下は不要    
//	@Autowired
//	public void configureAuthenticationManager(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(accountUserDetailsService).passwordEncoder(passwordEncoder());
//	}
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
