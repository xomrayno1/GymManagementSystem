package com.tampro.dto;

import java.util.Date;

public class UserRoleDTO {
	private int id;
	private int idUser;
	private RoleDTO roleDTO;
	private Date createDate;
	private Date updateDate;
	private int activeFlag;
	private int idRole;
	
	
	
	
	
	public UserRoleDTO(RoleDTO roleDTO) {
		super();
		this.roleDTO = roleDTO;
	}
	public UserRoleDTO(int id ,int idUser, int idRole) {
		super();
		this.id = id;
		this.idUser = idUser;
		this.idRole = idRole;
	}
	public UserRoleDTO(int idUser, int idRole) {
		super();
		this.idUser = idUser;
		this.idRole = idRole;
	}
	public UserRoleDTO() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public RoleDTO getRoleDTO() {
		return roleDTO;
	}
	public void setRoleDTO(RoleDTO roleDTO) {
		this.roleDTO = roleDTO;
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
	public int getIdRole() {
		return idRole;
	}
	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}
	
	
	
	
}
