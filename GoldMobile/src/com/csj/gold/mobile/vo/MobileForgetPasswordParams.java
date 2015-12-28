package com.csj.gold.mobile.vo;


public class MobileForgetPasswordParams extends MobileParams {
	private String messageCode;
	
	private String password;

	public String getMessageCode() {
		return messageCode;
	}

	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
