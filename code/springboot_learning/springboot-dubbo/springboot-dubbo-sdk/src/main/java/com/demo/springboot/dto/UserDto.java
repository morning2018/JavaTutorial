package com.demo.springboot.dto;

import java.io.Serializable;

/**
 * 用户dto <br> 
 *  
 * @author morning<br>
 * @version 0.1<br>
 * @CreateDate 2017年11月14日 <br>
 * @since v0.1<br>
 * @see com.demo.springboot.dto <br>
 */
public class UserDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1662271902540259155L;
	
	private String username;
	private Long userId;
	private String email;
	private String password;
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "UserDto [username=" + username + ", userId=" + userId + ", email=" + email + ", password=" + password
				+ "]";
	}
}
