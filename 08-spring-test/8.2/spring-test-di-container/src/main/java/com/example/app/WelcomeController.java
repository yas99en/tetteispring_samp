package com.example.app;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {
	
	private final DataSource dataSource;
	
	@Autowired
	public WelcomeController(DataSource dataSource) {
		this.dataSource = dataSource;
	}
    
    @GetMapping("/")
    public String home(Model model) {
    	try (Connection conn = dataSource.getConnection()) {
    		// 接続先データベースの情報を確認する
			model.addAttribute("dataSource", conn.getMetaData().getDatabaseProductName());
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return "index";
    }

}
