package com.app.controller;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.ui.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	public HelloController() {
System.out.println("IN cnstor of"+ getClass().getName());	
}
	//first request handling methd for testing the flow
	@RequestMapping("/test")
	public String testme() {
		System.out.println("in test me ()");
	return "/hello";
	}
	
	
	@RequestMapping("/model")
	public ModelAndView hello2()
	{
		System.out.println("in model  view hello2 ");

		return new ModelAndView("/welcome","server_live_time", LocalDateTime.now());
		
	}
	
	@RequestMapping("/modelmap")
	public String hello3(Model map)
	{
		System.out.println("in model map");
		map.addAttribute("server_time",LocalDateTime.now());
		map.addAttribute("numbers1", Arrays.asList(1,2,3,4,5));
		System.out.println(map);
		
		return "/welcome123";
		
	}
	
	
}
