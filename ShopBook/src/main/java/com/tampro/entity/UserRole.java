package com.tampro.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class UserRole{
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name = "role_id")
	private Role role;
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	private Date createDate;
	private Date updateDate;
	private int activeFlag;
	
	public UserRole() {
	
	}
	
	public UserRole(int id) {
		this.id = id;
	}
	
	
	public UserRole(Role role , User user) {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
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
	
	
	
	
}
