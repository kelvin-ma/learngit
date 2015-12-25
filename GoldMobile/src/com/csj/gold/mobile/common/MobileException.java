package com.csj.gold.mobile.common;



public class MobileException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5850298137707184689L;

	private String transNo;
	private String code;
	private String desc;

	public MobileException() {
	}


	public MobileException(String message, Throwable cause) {
		super(message, cause); 
	}

	public MobileException(String message) {
		super(message);
	}

	public MobileException(Throwable cause) {
		super(cause);
	}

	public MobileException(String code, String desc) {
		super(code + ":" + desc);
		this.code = code;
		this.desc = desc;
	}

	public MobileException(String transNo, String code, String desc) {
		this(code, desc);
		this.transNo = transNo;
	}

	public String getTransNo() {
		return transNo;
	}

	public void setTransNo(String transNo) {
		this.transNo = transNo;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
