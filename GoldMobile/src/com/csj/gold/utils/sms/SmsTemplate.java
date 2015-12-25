package com.csj.gold.utils.sms;

public class SmsTemplate {

	private String name;
	
	private String template;
	/**
	 * 发送单条信息的最小时间间隔
	 */
	private Integer  minTimeInterval;
	/**
	 * 最大时间范围 S
	 */
	private Integer  maxTimeFrame; 
	
	/**
	 * 满足时间范围最大条数   
	 */
	private Integer timeFrameSmsNum;
	
}
