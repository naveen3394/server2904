package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")

public class UserController {

	public UserController() {
	System.out.println("inside cnstr :"+getClass().getName());	// TODO Auto-generated constructor stub
	}
	
	
	@RequestMapping("/login")
	public String ValidateUser(Model map,@RequestParam(name="email") String reqemail,@RequestParam(name="password") String reqpass) {
	System.out.println("inside validate login");
		map.addAttribute("user_dtls",reqemail+reqpass);
		return "/user/details";
		
	}
}
