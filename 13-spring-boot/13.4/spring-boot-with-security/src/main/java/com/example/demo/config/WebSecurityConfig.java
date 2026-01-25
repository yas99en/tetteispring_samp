package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.PathPatternRequestMatcher;


// 13.4.2. 認証・認可のカスタマイズ フォーム認証を適用するためのBean定義例
@Configuration
public class WebSecurityConfig {

//    private AccountUserDetailsService accountUserDetailsService;
//
//    @Autowired
//    public WebSecurityConfig(AccountUserDetailsService accountUserDetailsService) {
//        this.accountUserDetailsService = accountUserDetailsService;
//    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(requests -> requests
           		.requestMatchers(PathPatternRequestMatcher.withDefaults().matcher("/")).permitAll()
           		.requestMatchers(PathPatternRequestMatcher.withDefaults().matcher("/home")).permitAll()
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .loginPage("/login")
                .permitAll()
            )
            .logout(logout -> logout.permitAll());

        return http.build();
    }

// SpringBoot3では不要
//	// 13.4.2. 認証・認可のカスタマイズ 自作のUserDetailsServiceを適用するためのBean定義例
//    @Autowired
//    public void configureAuthenticationManager(AuthenticationManagerBuilder auth) throws Exception {
//    	auth.userDetailsService(accountUserDetailsService);
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}