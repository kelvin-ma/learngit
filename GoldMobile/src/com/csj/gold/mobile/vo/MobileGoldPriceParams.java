package com.csj.gold.mobile.vo;

import java.util.Date;

public class MobileGoldPriceParams extends MobileParams {
	
	private Date stratTime;
	
	private Date endTime;

	public Date getStratTime() {
		return stratTime;
	}

	public void setStratTime(Date stratTime) {
		this.stratTime = stratTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
}
