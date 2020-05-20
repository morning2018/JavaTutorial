package com.demo.springboot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.demo.springboot.enums.GenderEnum;
import com.demo.springboot.po.UserPo;

/**
 * 基于注解形式实现mybatis,适用于快速开发，非复杂的sql开发
 * @author morning
 *
 */
public interface UserMapper {
	
	@Select("SELECT * FROM sys_user")
	@Results({
		@Result(property = "gender",  column = "gender", javaType = GenderEnum.class),
		@Result(property = "email", column = "email")
	})
	List<UserPo> getAll();
	
	@Select("SELECT * FROM sys_user WHERE user_id = #{id}")
	@Results({
		@Result(property = "gender",  column = "gender", javaType = GenderEnum.class),
		@Result(property = "email", column = "email")
	})
	UserPo getOne(Long id);

	@Insert("INSERT INTO sys_user(username,password,gender,email) VALUES(#{username}, #{password}, #{gender}, #{email})")
	void insert(UserPo user);

	@Update("UPDATE sys_user SET username=#{username},email=#{email} WHERE user_id =#{id}")
	void update(UserPo user);

	@Delete("DELETE FROM sys_user WHERE user_id =#{id}")
	void delete(Long id);

}