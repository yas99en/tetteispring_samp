package com.example.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.service.account.AuthorizationService;

@Controller
@RequestMapping("general")
public class GeneralController {
	
	private AuthorizationService authorizationService;

	@Autowired
	public GeneralController(AuthorizationService authorizationService) {
		this.authorizationService = authorizationService;
	}
	
	@GetMapping()
	public String general() {
		AccessDeniedException exception = null;
		
		try {
			authorizationService.test("一般ユーザー");
		} catch(AccessDeniedException e) {
			System.out.println("test アクセス不可");
			exception = e;
		}
		
		try {
			authorizationService.testPostAuthorize("一般ユーザー");
		} catch(AccessDeniedException e) {
			System.out.println("testPostAuthorize アクセス不可" );
			exception = e;
		}
		
		if (exception != null) {
			throw exception;
		}

		return "general"; 
	}
}
