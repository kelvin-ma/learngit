package com.csj.gold.utils.sms;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import com.alibaba.druid.support.logging.Log;
import com.alibaba.druid.support.logging.LogFactory;
import com.csj.gold.utils.http.HttpRequest;
import com.csj.gold.utils.sms.shwsms.ShwsmsConstantEnum;
import com.csj.gold.utils.sms.shwsms.ShwsmsConstantEnum.ShwsmsEnum;
import com.sun.tools.apt.Main;

public class SmsSendUilt {
	
private static final Log log = LogFactory.getLog(SmsSendUilt.class);
	
	private static final String url="http://sms.shwsms.com/httpInterfaceSubmitAction.do?account=kelvin&password=e10adc3949ba59abbe56e057f20f883e";
	
	
	public static String sendSMS(String phone,  String content ) {
		try {
		String sendUrl = url+"&mobile="+phone+"&content="+URLEncoder.encode(content, "UTF-8");
		HttpRequest.sendGet(sendUrl);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "";
	}

	public static String sendSmsCheckCode(String phone,  String checkCode ){
		
		 String content="【一寸金】您正在注册一寸金会员，手机验证码为"+checkCode+"(10分钟内有效)，如非本人操作请忽略";
		 return sendSMS(phone,content);
		 
	}
}
 