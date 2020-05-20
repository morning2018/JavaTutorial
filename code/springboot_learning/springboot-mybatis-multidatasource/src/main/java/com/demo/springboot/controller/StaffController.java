package com.demo.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.demo.springboot.dto.StaffDto;
import com.demo.springboot.mapper.datasource2.StaffMapper;
import com.demo.springboot.po.StaffPo;
import com.demo.springboot.util.TransUtil;

@Controller
@RequestMapping("/staff")
public class StaffController {
	
	@Autowired
	private StaffMapper staffMapper;
	
	@RequestMapping("/addstaff")
	public ModelAndView addStaff(StaffDto staff) {
		ModelAndView mv = new ModelAndView("staff_detail");
		StaffPo staffPo = TransUtil.dto2po(staff, StaffPo.class);
		if (staffPo != null) {
			staffMapper.insert(staffPo);
		}
		mv.addObject("staff", staffPo);
		return mv;
	}
}
