package com.csj.gold.utils.sms;

import com.csj.gold.mobile.annotation.InterfaceEnum;

public class SendMessage {
	

	/**
	 * 发送模板代码
	 */
	private Integer templateCode;
	/**
	 * 用户id
	 */
	private Integer userId;
	/**
	 * 业务代码
	 */
	private InterfaceEnum  businessCode;
	/**
	 * 短信发送内容
	 */
	private String  content;
	/**
	 * 短信发送时间
	 */
	private Long sendTime;
	/**
	 * 发送短信手机号
	 */
	private String  phone;
	/**
	 * 短信发送模板
	 */
	private SmsTemplate smsTemplate;
	/**
	 * 发送状态
	 */
	private  SendStateEnum stateEnum;
	/**
	 * 已发送条数
	 */
	private Integer num;
	/**
	 * 时间间隔:首条至最后一条时间差 
	 */
	private  Long timeInterval;  
	/**
	 * 短信验证码
	 */
	private String smsCode;
	/**
	 * 下一条发送时间阀值
	 * 最后一条发送时间+两条发送时间间隔秒数 默认是 +59s
	 * 当被限制时,返回下一次发送时间阀值
	 */
	private Long nextSendTime;
	
	public Long getNextSendTime() {
		return nextSendTime;
	}

	public void setNextSendTime(Long nextSendTime) {
		this.nextSendTime = nextSendTime;
	}

	public Integer getTemplateCode() {
		return templateCode;
	}

	public void setTemplateCode(Integer templateCode) {
		this.templateCode = templateCode;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getSendTime() {
		return sendTime;
	}

	public void setSendTime(Long sendTime) {
		this.sendTime = sendTime;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public InterfaceEnum getBusinessCode() {
		return businessCode;
	}

	public void setBusinessCode(InterfaceEnum businessCode) {
		this.businessCode = businessCode;
	}

	public SmsTemplate getSmsTemplate() {
		return smsTemplate;
	}

	public void setSmsTemplate(SmsTemplate smsTemplate) {
		this.smsTemplate = smsTemplate;
	}

	public SendStateEnum getStateEnum() {
		return stateEnum;
	}

	public void setStateEnum(SendStateEnum stateEnum) {
		this.stateEnum = stateEnum;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Long getTimeInterval() {
		return timeInterval;
	}

	public void setTimeInterval(Long timeInterval) {
		this.timeInterval = timeInterval;
	}

	public String getSmsCode() {
		return smsCode;
	}

	public void setSmsCode(String smsCode) {
		this.smsCode = smsCode;
	}
	
	
	
	
}
