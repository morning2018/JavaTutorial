package com.demo.springcloud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.springcloud.entity.InterfaceLimit;
import com.demo.springcloud.mapper.InterfaceLimitMapper;
import com.demo.springcloud.service.InterfaceLimitService;

@Service
public class InterfaceLimitServiceImpl implements InterfaceLimitService {
	
	@Autowired
	private InterfaceLimitMapper mapper;

	@Override
	public InterfaceLimit getEntityByPri(Integer id) {
		return mapper.selectByPrimaryKey(id);
	}

}
