package com.demo.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.demo.springboot.dto.UserDto;

@Controller
@RequestMapping("/user")
public class UserController {
	@RequestMapping("/adduser")
	public ModelAndView addUser(UserDto user) {
		ModelAndView mv = new ModelAndView("user_detail");
		mv.addObject("user", user);
		return mv;
	}
}
