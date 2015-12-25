
package com.csj.gold.utils.sms;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.alibaba.druid.support.logging.Log;
import com.alibaba.druid.support.logging.LogFactory;
import com.csj.gold.mobile.RegistTransation;




/**
 * 短信配置
 * @author kelvin
 *
 */
public class SmsClientConfiguration {
	private static final Log log = LogFactory.getLog(SmsClientConfiguration.class);
	
    private	String ACCESS_KEY_ID ;
    private String SECRET_ACCESS_KEY ;
    private String ENDPOINT_URL ;
    private String USER_NAME;
    private String PASSWORD;
    
    private  String smsConfigFile="smsConfig.properties";
    
    private  String smsTemplateFile="smsTemplate.properties";
    /**
     * 短信信息对象
     */
    private SendMessageRequest messageRequest=new SendMessageRequest();
    /**
     * 短信模板对象
     */
    private  final Map<String,SmsTemplate> smsTemplateMap=new HashMap<String, SmsTemplate>();
    /**
	 * 懒加载
	 * @author kelvin
	 *
	 */
	private static class  SmsClientConfigurationHolder{
		private final static SmsClientConfiguration SMS_CLIENT_CONFIGURATION = new SmsClientConfiguration();
		
	}
    
    private  SmsClientConfiguration(){
    	//加载短信模板
    	Properties smsPps = new Properties();
//    	pps.load(new FileInputStream("smsConfig.properties"));
    	//smsTemplateMap= new  HashMap<String , SmsTemplate>();
    	
    	//初始化配置文件
    	
    }
    
    private void initConfig(){
    	Properties pps = new Properties();
    	
    	try {
			pps.load(new FileInputStream(smsConfigFile));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}       
//    	this.ACCESS_KEY_ID=pps.getProperty("sms.shwsms.url");
//    	this.SECRET_ACCESS_KEY=pps.getProperty("sms.shwsms.url");
    	this.ENDPOINT_URL=pps.getProperty("sms.shwsms.url");
    	this.USER_NAME=pps.getProperty("sms.shwsms.username");
    	this.PASSWORD=pps.getProperty("sms.shwsms.url");
    	
    }
    
    private void initTemplate(){
//    	Properties pps = new Properties();
//    	
//    	try {
//			pps.load(new FileInputStream(smsTemplateFile));
//			
//			for (Object s  :pps.entrySet()) {
//				
//			}
//			pps.getProperty(key)
//    	
//    	} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			
//			
//		}       
//    	this.ACCESS_KEY_ID=pps.getProperty("sms.shwsms.url");
//    	this.SECRET_ACCESS_KEY=pps.getProperty("sms.shwsms.url");
//    	this.ENDPOINT_URL=pps.getProperty("sms.shwsms.url");
//    	this.USER_NAME=pps.getProperty("sms.shwsms.username");
//    	this.PASSWORD=pps.getProperty("sms.shwsms.url");
    	
    }
    
    private String[] classFieldNames(String className ){
		try {
			Class<?> clz;
			clz = Class.forName(className);
			Field[] fields= clz.getDeclaredFields();
			for (Field field : fields) {
				field.getName();
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	//Class clz="cddd".class;
    	
    	
    	return new String[2];
    }
    
    /**
	 * 返回配置
	 * @return
	 */
	 public static final SmsClientConfiguration getInstance(){
		 return SmsClientConfigurationHolder.SMS_CLIENT_CONFIGURATION;
	 }
	
	 public SmsClient createSmsClient() {
	    return new ShwSmsClient(this);
	 }

	public String getACCESS_KEY_ID() {
		return ACCESS_KEY_ID;
	}

	public void setACCESS_KEY_ID(String aCCESS_KEY_ID) {
		ACCESS_KEY_ID = aCCESS_KEY_ID;
	}

	public String getSECRET_ACCESS_KEY() {
		return SECRET_ACCESS_KEY;
	}

	public void setSECRET_ACCESS_KEY(String sECRET_ACCESS_KEY) {
		SECRET_ACCESS_KEY = sECRET_ACCESS_KEY;
	}

	public String getENDPOINT_URL() {
		return ENDPOINT_URL;
	}

	public void setENDPOINT_URL(String eNDPOINT_URL) {
		ENDPOINT_URL = eNDPOINT_URL;
	}

	public String getUSER_NAME() {
		return USER_NAME;
	}

	public void setUSER_NAME(String uSER_NAME) {
		USER_NAME = uSER_NAME;
	}

	public String getPASSWORD() {
		return PASSWORD;
	}

	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}

	public SendMessageRequest getMessageRequest() {
		return messageRequest;
	}

	
	 
	 
}
