package com.demo.springboot.mapper.datasource1;

import java.util.List;

import com.demo.springboot.po.UserPo;

public interface UserMapper {
	
	List<UserPo> getAll();
	
	UserPo getOne(Long id);

	void insert(UserPo user);

	void update(UserPo user);

	void delete(Long id);

}