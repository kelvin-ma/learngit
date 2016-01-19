package com.csj.gold.mobile.vo;

import org.hibernate.validator.constraints.NotEmpty;

import com.csj.gold.mobile.common.GroupOne;
import com.csj.gold.mobile.common.GroupTwo;

public class MobileMessageCodeParams extends MobileParams {
	
	@NotEmpty(message = "{user.name.null}",groups={GroupOne.class})  
	private String typeCode ;
	
	@NotEmpty(message = "{user.name.null}",groups={GroupTwo.class})
	private String messageCode;

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	public String getMessageCode() {
		return messageCode;
	}

	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}
	
}
