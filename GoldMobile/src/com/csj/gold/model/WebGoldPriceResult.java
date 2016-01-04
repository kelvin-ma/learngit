package com.csj.gold.model;

import java.util.List;
import java.util.Map;

public class WebGoldPriceResult {
	private String resultcode;
	private String reason;
	private List<Map<String,WebGoldPrice>> result;
	private Map<String,WebGoldPrice> priceMap;
	private String error_code;

	public String getResultcode() {
		return resultcode;
	}

	public void setResultcode(String resultcode) {
		this.resultcode = resultcode;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}


	public List<Map<String, WebGoldPrice>> getResult() {
		return result;
	}

	public void setResult(List<Map<String, WebGoldPrice>> result) {
		this.result = result;
	}

	public String getError_code() {
		return error_code;
	}

	public void setError_code(String error_code) {
		this.error_code = error_code;
	}

	public Map<String, WebGoldPrice> getPriceMap() {
		if(null != result && result.size()>0){
			return result.get(0);
		}
		return null;
	}

}
