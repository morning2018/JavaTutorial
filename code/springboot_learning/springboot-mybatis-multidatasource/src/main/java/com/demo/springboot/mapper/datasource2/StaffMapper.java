package com.demo.springboot.mapper.datasource2;

import java.util.List;

import com.demo.springboot.po.StaffPo;

public interface StaffMapper {
	
	List<StaffPo> getAll();
	
	StaffPo getOne(Long id);

	void insert(StaffPo staff);

	void update(StaffPo staff);

	void delete(Long id);

}