package com.csj.gold.mobile.vo;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.csj.gold.mobile.common.MobileStateConstants;

public class MobileResult {

	private String transNo;
	private String resultCode;
	private String resultDesc;
	
	private List<Error> errors;
 
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

	public List<Error> getErrors() {
		return errors;
	}

	public void setErrors(List<Error> errors) {
		this.errors = errors;
	}


	public   void  addError(BindingResult result){
		if(result==null||!result.hasErrors()){
			return;
		}
		this.errors =new ArrayList<Error>();
		for(FieldError error:result.getFieldErrors()){
			Error error2=new Error();
			//error2.setErrorCode()
			error2.setErrorType(error.getCode());
			error2.setField(error.getField());
			try {
				String	msg = new String(error.getDefaultMessage().getBytes("iso-8859-1"),"UTF-8");
				error2.setMsg(msg);
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.errors.add(error2);
		}
		this.resultCode=String.valueOf(MobileStateConstants.MobileConstants.WRONG_PARAMETER.getIndex());
		this.resultDesc=MobileStateConstants.MobileConstants.WRONG_PARAMETER.getName();
	
	}
	
	 
}
