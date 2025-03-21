package com.example.app;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.domain.model.Properties;
import com.example.domain.model.User;
import com.example.domain.service.UserService;

@Controller
public class WelcomeController {
	
	private final UserService service;
	
	private final BasicDataSource dataSource;
	
	private final Properties properties;
	
	@Autowired
	public WelcomeController(UserService service, Properties properties, DataSource dataSource) {
		this.service = service;
		this.properties = properties;
		this.dataSource =  (BasicDataSource) dataSource;
	}
	
    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home() {
    	User user = new User();
    	user.setUsername("DummyUser1");
    	service.register(user, "DummyPassword1");
    	
		System.out.println("プロファイル名を指定したJava Configの動作確認: プロファイル選択を「production」、「development」または「test」と切り替えることで出力が「info」、「debug」と切り替わり、Java Configを正しく切り替えられていることが分かる");
		System.out.println("Profile: " + properties.getProfileString());
		System.out.println();
		
		System.out.println("メソッドレベルにプロファイル名を指定したJava Configの動作確認: プロファイル選択を「production」、「development」、「test」と切り替えることで出力がそれぞれの情報に切り替わり、Bean定義を正しく切り替えられていることが分かる");
		System.out.println("DriverClassName: " + dataSource.getDriverClassName());
		System.out.println("Url: " + dataSource.getUrl());
		System.out.println("Username: " + dataSource.getUsername());
		System.out.println("Password: " + dataSource.getPassword());
		System.out.println();
		
		System.out.println("プロファイル名を指定したアノテーションによるBean定義の動作確認: プロファイル選択を「production」、「development」または「test」と切り替えることで出力が「UserRepositoryImpl」、「DummyUserRepositoryImpl」と切り替わり、アノテーションによるBean定義を正しく切り替えられていることが分かる");
		user = new User();
		user.setUsername("DummyUser_profile");
		service.register(user, "DummyUser_profile");
    	
        return "index";
    }
    
}