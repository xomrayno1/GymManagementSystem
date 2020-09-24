package com.tampro.dto;

public class AuthDTO extends Base {
	private int id;
	private int idRole;
	private MenuDTO menuDTO;
	private int permission;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdRole() {
		return idRole;
	}
	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}
	public MenuDTO getMenuDTO() {
		return menuDTO;
	}
	public void setMenuDTO(MenuDTO menuDTO) {
		this.menuDTO = menuDTO;
	}
	public int getPermission() {
		return permission;
	}
	public void setPermission(int permission) {
		this.permission = permission;
	}
	
	
	

}
