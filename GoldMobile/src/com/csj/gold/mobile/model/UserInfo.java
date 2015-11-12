package com.csj.gold.mobile.model;

import java.io.Serializable;
import java.util.Date;
 
public class UserInfo implements Serializable {
	
	private Integer id;//id
	  
	private String userName;//用户姓名
	  
	private String phone;// 手机号
	  
	private String certNo;//身份证号
	  
	private Date createTime;//创建时间
	
	private Date updateTime;//修改时间
	  
	private Integer updateUser;//修改人

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCertNo() {
		return certNo;
	}

	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(Integer updateUser) {
		this.updateUser = updateUser;
	}

	
	
}