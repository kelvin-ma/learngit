package com.csj.gold.mobile.vo;

import java.io.File;

import org.springframework.web.multipart.MultipartFile;

public class MobileUserAllInfoParams extends MobileParams {
	private String certNo = null;

	private String userName = null;

	private String oldPassword = null;

	private String newPassword = null;

	private MultipartFile userImage = null;
	
	private File image ;
	
	public String getCertNo() {
		return certNo;
	}

	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public MultipartFile getUserImage() {
		return userImage;
	}

	public void setUserImage(MultipartFile userImage) {
		this.userImage = userImage;
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

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

}
