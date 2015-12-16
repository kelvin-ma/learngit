package com.csj.gold.mobile.vo;



public class MobileResult {

	private String transNo;
	private String resultCode;
	private String resultDesc;
//	private MobilePagerParams pagerParams;
//
//	public MobilePagerParams getPagerParams() {
//		if (pagerParams == null) {
//			pagerParams = new MobilePagerParams();
//		}
//		return pagerParams;
//	}
//
//	public void setPagerParams(MobilePagerParams pagerParams) {
//		this.pagerParams = pagerParams;
//	}

	public String getTransNo() {
		return transNo;
	}

	public void setTransNo(String transNo) {
		this.transNo = transNo;
	}

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultDesc() {
		return resultDesc;
	}

	public void setResultDesc(String resultDesc) {
		this.resultDesc = resultDesc;
	}

}
