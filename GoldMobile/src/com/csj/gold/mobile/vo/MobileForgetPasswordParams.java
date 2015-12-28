package com.csj.gold.mobile.vo;


public class MobileForgetPasswordParams extends MobileParams {
	private String checkCode;
	
	private String password;

	public String getCheckCode() {
		return checkCode;
	}

	public void setCheckCode(String checkCode) {
		this.checkCode = checkCode;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
