package com.csj.gold.model.bean;

public class MobileShop {
	private Long id;

	private String shopName;

	private String shopAddress;

	private Double shopCoordinateEast;

	private Double shopCoordinateNorth;

	private Long shopImageId;

	private String shopImagePath;

	private String shopPhone;

	private Integer shopType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getShopAddress() {
		return shopAddress;
	}

	public void setShopAddress(String shopAddress) {
		this.shopAddress = shopAddress;
	}

	public Double getShopCoordinateEast() {
		return shopCoordinateEast;
	}

	public void setShopCoordinateEast(Double shopCoordinateEast) {
		this.shopCoordinateEast = shopCoordinateEast;
	}

	public Double getShopCoordinateNorth() {
		return shopCoordinateNorth;
	}

	public void setShopCoordinateNorth(Double shopCoordinateNorth) {
		this.shopCoordinateNorth = shopCoordinateNorth;
	}

	public Long getShopImageId() {
		return shopImageId;
	}

	public void setShopImageId(Long shopImageId) {
		this.shopImageId = shopImageId;
	}

	public String getShopImagePath() {
		return shopImagePath;
	}

	public void setShopImagePath(String shopImagePath) {
		this.shopImagePath = shopImagePath;
	}

	public String getShopPhone() {
		return shopPhone;
	}

	public void setShopPhone(String shopPhone) {
		this.shopPhone = shopPhone;
	}

	public Integer getShopType() {
		return shopType;
	}

	public void setShopType(Integer shopType) {
		this.shopType = shopType;
	}

}
