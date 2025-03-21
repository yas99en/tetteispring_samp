package com.example.demo.config;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.example.demo.domain.repository.UserRepository;
import com.example.demo.domain.repository.UserRepositoryImpl;
import com.example.demo.domain.service.UserService;
import com.example.demo.domain.service.ConstructorInjectionUserServiceImpl;
import com.example.demo.domain.service.FieldInjectionUserServiceImpl;
import com.example.demo.domain.service.SetterInjectionUserServiceImpl;
import com.example.demo.domain.service.collection.IF;
import com.example.demo.domain.service.collection.IntIF1;
import com.example.demo.domain.service.collection.IntIF2;
import com.example.demo.domain.service.collection.StringIF;
import com.example.demo.domain.service.password.BCryptPasswordEncoder;
import com.example.demo.domain.service.password.Lightweight;
import com.example.demo.domain.service.password.PasswordEncoder;
import com.example.demo.domain.service.password.Sha256PasswordEncoder;

// 2.1.2. ApplicationContextとBean定義 Java Configクラスの実装例
// 2.1.3.1. JavaベースConfiguration Bean定義を行なうJava Configの実装例
@Configuration
public class AppConfig {
	
	@Bean
    UserRepository userRepository() {
        return new UserRepositoryImpl();
    }
	
	// フィールドインジェクション
    @Bean
    UserService fieldInjectionUserService() {
        return new FieldInjectionUserServiceImpl();
    }
    
    // 2.1.3.1. JavaベースConfiguration メソッド引数経由でBeanを注入する実装例
    @Bean
    UserService constructorInjectionUserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return new ConstructorInjectionUserServiceImpl(userRepository, passwordEncoder);
    }
    
    // 2.1.4.1. セッターインジェクション セッターインジェクションを行なう引数を持ったJavaベースConfigurationの実装例
    @Bean
    UserService setterInjectionUserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        SetterInjectionUserServiceImpl userService = new SetterInjectionUserServiceImpl();
        userService.setUserRepository(userRepository);
        userService.setPasswordEncoder(passwordEncoder);
        return userService;
    }
    
    // 2.1.5.1. 型によるオートワイヤリング SHA-256とBCryptの2つのPasswordEncoderを定義するJava Config(BCryptには@Primaryを付与) 作成した@Lightweightアノテーションを付与したBean定義を含むJava Configの実装例
 	@Bean
 	@Lightweight
    PasswordEncoder sha256PasswordEncoder() {
 		return new Sha256PasswordEncoder();
    }

    @Bean
    @Primary
    PasswordEncoder bcryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    // 2.1.5.3. コレクションやマップ型のオートワイヤリング リストやマップのBean定義の実装例
	@Bean
	List<IF<?>> ifList() {
		return Arrays.asList(new IntIF1(), new IntIF2(), new StringIF()); 
	}
	
	@Bean
	Map<String, IF<?>> ifMap() {
		Map<String, IF<?>> map = new HashMap<>(); 
		map.put("intIF1", new IntIF1()); 
		map.put("intIF2", new IntIF2()); 
		map.put("stringIF", new StringIF()); 
		return map;
	}

}
