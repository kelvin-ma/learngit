package com.csj.gold.model;

import java.util.Date;

public class UserInfo {
	private Long id;

	private String userName;

	private String phone;

	private Long headImageFileId;

	private String certNo;

	private Date createDate;

	private Date updateDate;

	private Long updateUser;

	private Long createUser;

	private Integer isDel;

	private Integer isForbidden;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName == null ? null : userName.trim();
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone == null ? null : phone.trim();
	}

	public String getCertNo() {
		return certNo;
	}

	public void setCertNo(String certNo) {
		this.certNo = certNo == null ? null : certNo.trim();
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

	public Long getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(Long updateUser) {
		this.updateUser = updateUser;
	}

	public Long getCreateUser() {
		return createUser;
	}

	public void setCreateUser(Long createUser) {
		this.createUser = createUser;
	}

	public Integer getIsDel() {
		return isDel;
	}

	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}

	public Integer getIsForbidden() {
		return isForbidden;
	}

	public void setIsForbidden(Integer isForbidden) {
		this.isForbidden = isForbidden;
	}

	public Long getHeadImageFileId() {
		return headImageFileId;
	}

	public void setHeadImageFileId(Long headImageFileId) {
		this.headImageFileId = headImageFileId;
	}

}