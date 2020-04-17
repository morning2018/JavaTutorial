package com.demo.springboot.service;

import com.demo.springboot.dto.UserDto;

/**
 * 
 * 用户服务 <br> 
 *  
 * @author morning<br>
 * @version 0.1<br>
 * @CreateDate 2017年11月14日 <br>
 * @since v0.1<br>
 * @see com.demo.springboot.service <br>
 */
public interface UserService {

    /**
     * 查询用户 <br> 
     *  
     * @author morning<br>
     * @param userName
     * @return <br>
     */
    UserDto findUserByName(String userName);
}
