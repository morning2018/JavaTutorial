package com.demo.springboot.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserDto implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -1662271902540259155L;
	
	private String username;
	private Long userId;
	private String email;
	private String password;
}
