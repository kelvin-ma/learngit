
package com.csj.gold.utils.sms;

import sun.security.provider.MD5;

import com.alibaba.druid.support.logging.Log;
import com.alibaba.druid.support.logging.LogFactory;
import com.csj.gold.utils.MD5Tools;
import com.csj.gold.utils.http.HttpRequest;


public class ShwSmsClient implements SmsClient{
    
	private  enum ShwsmsEnum{
		account,password,mobile,content
	}
	private static final Log log = LogFactory.getLog(ShwSmsClient.class);
	
	private  String url="http://sms.shwsms.com/httpInterfaceSubmitAction.do";
   
	private String username="kelvin";
	
	private String password="111111";

	private String content="111111";
	
	
	
	private SendMessageRequest messageRequest;
  
    public ShwSmsClient(SmsClientConfiguration config) {
    	if(config!=null){
    		
	    	this.url =config.getENDPOINT_URL();
	    	this.username=  config.getUSER_NAME();
	    	this.password =config.getPASSWORD();
	    	this.content =config.getPASSWORD();
	    	this.messageRequest =config.getMessageRequest();
	    
    	}
    }

	@Override
	public String sendMessage() {
		
		if(messageRequest!=null){
			StringBuilder str =new StringBuilder();
			str.append(ShwsmsEnum.account).append("=")
			.append(username).append("&")
			.append(ShwsmsEnum.password).append("=")
			.append(MD5Tools.MD5(password)).append("&")
			.append(ShwsmsEnum.mobile).append("=")
			.append(messageRequest.getPhone()).append("&")
			.append(ShwsmsEnum.content).append("=")
			.append(messageRequest.getContent());
			HttpRequest.sendGet(url, str.toString());
		}
		
		return null;
	}

	@Override
	public String sendMessage(String content) {
		// TODO Auto-generated method stub
		this.content=content;
		return sendMessage();
	}

	@Override
	public String sendMessage(String phone, String content) {
		this.messageRequest.setPhone(phone);
		return sendMessage(content);
	}
	
	
  

}