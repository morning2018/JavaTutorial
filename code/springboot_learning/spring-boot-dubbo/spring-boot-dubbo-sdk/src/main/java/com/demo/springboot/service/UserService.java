package com.demo.springboot.service;

import com.demo.springboot.dto.UserDto;

/**
 * 
 * �û����� <br> 
 *  
 * @author morning<br>
 * @version 0.1<br>
 * @CreateDate 2017��11��14�� <br>
 * @since v0.1<br>
 * @see com.demo.springboot.service <br>
 */
public interface UserService {

    /**
     * ��ѯ�û� <br> 
     *  
     * @author morning<br>
     * @param userName
     * @return <br>
     */
    UserDto findUserByName(String userName);
}
