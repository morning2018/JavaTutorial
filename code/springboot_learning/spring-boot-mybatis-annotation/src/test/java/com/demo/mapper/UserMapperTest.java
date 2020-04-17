package com.demo.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.springboot.Application;
import com.demo.springboot.enums.GenderEnum;
import com.demo.springboot.mapper.UserMapper;
import com.demo.springboot.po.UserPo;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=Application.class)
public class UserMapperTest {	
	@Autowired
	private UserMapper userMapper;

	@Test
	public void testInsert() throws Exception {
		UserPo entity = new UserPo("lisi","zhangsan@123.com","123456",GenderEnum.MAN);
		userMapper.insert(entity);
	}
}