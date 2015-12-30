package com.csj.gold.mobile.vo;

public class MobileAdvertisementVO {

	private Long id;

	private Integer orderNumber;

	private String filePath;

	private String adLink;

	private String linkParameters;

	private Integer version;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getAdLink() {
		return adLink;
	}

	public void setAdLink(String adLink) {
		this.adLink = adLink;
	}

	public String getLinkParameters() {
		return linkParameters;
	}

	public void setLinkParameters(String linkParameters) {
		this.linkParameters = linkParameters;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

}
