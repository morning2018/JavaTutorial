package com.demo.util;

import org.junit.Test;

import com.demo.springboot.dto.UserDto;
import com.demo.springboot.enums.GnederEnum;
import com.demo.springboot.po.UserPo;
import com.demo.springboot.util.TransUtil;

public class TransUtilTest {
	
	@Test
	public void testCase() {
		UserDto userDto = new UserDto();
		userDto.setEmail("123@12.com");
		userDto.setGender(GnederEnum.MAN);
		userDto.setPassword("pass");
		userDto.setUserId(1L);
		userDto.setUsername("name");
		UserPo userPo = TransUtil.dto2po(userDto, UserPo.class);
		
		System.out.println("==================");
		System.out.println(userPo.toString());
		System.out.println("==================");
	}
	
	@Test
	public void testCase2() {
		UserPo userPo = new UserPo();
		userPo.setEmail("123@12.com");
		userPo.setPassword("pass");
		userPo.setUserId(1L);
		userPo.setUsername("name");
		userPo.setGender(GnederEnum.MAN);
		UserDto userDto = TransUtil.po2dto(userPo, UserDto.class);
		
		System.out.println("==================");
		System.out.println(userDto.toString());
		System.out.println("==================");
	}
}
