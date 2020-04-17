/*
 * Copyright 2012-2020 the original author or authors.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * @author lzhoumail@126.com/zhouli
 * Git http://git.oschina.net/zhou666/spring-cloud-7simple
 */
package cloud.simple.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import cloud.simple.model.User;

@FeignClient(name = "cloud-simple-service")
public interface FeignUserService {

	 @RequestMapping("/user")
	 public List<User> readUserInfo();
}
