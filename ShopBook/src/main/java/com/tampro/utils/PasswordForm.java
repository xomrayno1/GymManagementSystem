package com.tampro.utils;

public class PasswordForm {
	private String oldPassword;
	private String newPassword;
	private String repeatPassword;
	private int idUser;
	
	
	
	public PasswordForm() {
	
	}
	public PasswordForm(int idUser) {
		super();
		this.idUser = idUser;
	}
	public String getOldPassword() {
		return oldPassword;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public String getRepeatPassword() {
		return repeatPassword;
	}
	public void setRepeatPassword(String repeatPassword) {
		this.repeatPassword = repeatPassword;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	
	

}
