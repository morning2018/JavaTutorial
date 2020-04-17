package com.demo.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	@RequestMapping("/login")
	public ModelAndView login(String username,String password) {
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("username", username);
		mv.addObject("password", password);
		return mv;
	}
	
	@RequestMapping("/touser")
    public String toUser(){
        return "user";
    }
	
	@RequestMapping("/tostaff")
    public String toStaff(){
        return "staff";
    }
	
}
