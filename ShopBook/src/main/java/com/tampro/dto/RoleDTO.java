package com.tampro.dto;

import java.util.Date;
import java.util.Set;

public class RoleDTO {
	private int id;
	private String name;
	private String description;
	private Date createDate;
	private Date updateDate;
	private int activeFlag;
	private Set<AuthDTO> auths;
	
	
	
	
	public RoleDTO() {
		super();
	}
	public RoleDTO(int id) {
		super();
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	public Set<AuthDTO> getAuths() {
		return auths;
	}
	public void setAuths(Set<AuthDTO> auths) {
		this.auths = auths;
	}
	
	
	
	
}
