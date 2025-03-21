package com.example.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.domain.model.User;
import com.example.domain.service.UserService;

@Controller
public class WelcomeController {
	
	private final UserService service;
	
	@Autowired
	public WelcomeController(UserService service) {
		this.service = service;
	}
	
    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home() {
    	User user = new User();
    	user.setUsername("DummyUser1");
    	service.register(user, "DummyPassword1");
        return "index";
    }
    
}