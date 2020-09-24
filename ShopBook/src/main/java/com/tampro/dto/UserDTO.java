package com.tampro.dto;

import java.util.Date;
import java.util.Set;

public class UserDTO {
	private int id;
	private String username;
	private String password;
	private String email;
	private String name;
	private String phone;
	private Date birthDay;
	private Date createDate;
	private Date updateDate;
	private int activeFlag;
	private Set<UserRoleDTO> userRoleDTOs;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public int getActiveFlag() {
		return activeFlag;
	}
	public void setActiveFlag(int activeFlag) {
		this.activeFlag = activeFlag;
	}
	public Set<UserRoleDTO> getUserRoleDTOs() {
		return userRoleDTOs;
	}
	public void setUserRoleDTOs(Set<UserRoleDTO> userRoleDTOs) {
		this.userRoleDTOs = userRoleDTOs;
	}
	
	
	
	
}
