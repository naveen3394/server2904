package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.dao.IVendorDao;

@Controller
@RequestMapping("/vendor")
public class VendorController {
public VendorController() {

	System.out.println("inside cnstr :"+getClass().getName());	// TODO Auto-generated constructor stub

}

@Autowired
private IVendorDao vdao;

@RequestMapping("/login")
public String ValidateUser(Model map,@RequestParam(name="email") String reqemail,@RequestParam(name="password") String reqpass) {

	System.out.println(map);
	map.addAttribute("user_dtls",vdao.validateUser(reqemail, reqpass));
	
	System.out.println(map);
	return "/vendor/details";
}





}
