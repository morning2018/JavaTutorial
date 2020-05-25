package com.demo.springboot.dubbo.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.demo.springboot.dto.UserDto;
import com.demo.springboot.service.UserService;

/**
 * 用户服务 <br> 
 *  
 * @author morning<br>
 * @version 0.1<br>
 * @CreateDate 2017年11月14日 <br>
 * @since v0.1<br>
 * @see com.demo.springboot.dubbo.impl <br>
 */
// 注册为 Dubbo 服务
@Service(version = "1.0.0")
public class UserServiceImpl implements UserService {
	
	@Override
	public UserDto findUserByName(String userName) {
		UserDto user = new UserDto();
		user.setUserId(1L);
		user.setEmail("zhangsan@126.com");
		user.setPassword("123456");
		user.setUsername(userName);
		return user;
	}
}
