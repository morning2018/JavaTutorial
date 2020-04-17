package com.demo.springboot.dubbo;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Reference;
import com.demo.springboot.dto.UserDto;
import com.demo.springboot.service.UserService;

/**
 * 用户服务 <br> 
 *  
 * @author morning<br>
 * @version 0.1<br>
 * @CreateDate 2017年11月14日 <br>
 * @since v0.1<br>
 * @see com.demo.springboot.dubbo <br>
 */
@Component
public class UserConsumerService {

    @Reference(version = "1.0.0")
    UserService userService;

    public void printUserInfo() {
        String userName="zhangsan";
        UserDto user = userService.findUserByName(userName);
        System.out.println(user.toString());
    }
}
