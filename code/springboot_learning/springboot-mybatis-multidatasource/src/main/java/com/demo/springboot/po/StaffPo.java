package com.demo.springboot.po;

import java.io.Serializable;

import com.demo.springboot.enums.GnederEnum;

public class StaffPo implements Serializable {

	private static final long serialVersionUID = -1662271902540259155L;
	
	private String staffName;
	private Long id;
	private String email;
	private String phone;
	private GnederEnum gender;
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public GnederEnum getGender() {
		return gender;
	}
	public void setGender(GnederEnum gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "StaffPo [staffName=" + staffName + ", id=" + id + ", email=" + email + ", phone=" + phone + ", gender="
				+ gender + "]";
	}
}
