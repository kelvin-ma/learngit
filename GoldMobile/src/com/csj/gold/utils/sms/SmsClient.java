package com.csj.gold.utils.sms;

public interface SmsClient {

	/**
	 * 发送消息
	 * @return
	 */
	public String sendMessage();
	
	/**
	 * 发送消息
	 * @param content
	 * @return
	 */
	public String sendMessage(String content);
	
	/**
	 * 发送消息
	 * @param phone
	 * @param content
	 * @return
	 */
	public String sendMessage(String phone,String content);
	
}
