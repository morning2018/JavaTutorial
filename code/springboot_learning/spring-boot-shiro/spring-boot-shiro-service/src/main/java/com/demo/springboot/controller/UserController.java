package com.demo.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.demo.springboot.dto.UserDto;
import com.demo.springboot.mapper.UserMapper;
import com.demo.springboot.po.UserPo;
import com.demo.springboot.util.TransUtil;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserMapper userMapper;
	
	@RequestMapping("/adduser")
	public ModelAndView addUser(UserDto user) {
		ModelAndView mv = new ModelAndView("user_detail");
		UserPo userPo = TransUtil.dto2po(user, UserPo.class);
		if (userPo != null) {
			userMapper.insert(userPo);
		}
		mv.addObject("user", user);
		return mv;
	}
}
