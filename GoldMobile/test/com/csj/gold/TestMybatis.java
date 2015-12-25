package com.csj.gold;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.csj.gold.utils.sms.SmsTemplate;

public class TestMybatis {

	@Test
	public void test() throws NoSuchFieldException, SecurityException {
//		fail("Not yet implemented");
//		SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
//		sqlSessionFactoryBuilder.build(config)
		
Properties pps = new Properties();
    	
    	try {
    		InputStream s= this.getClass().getResourceAsStream("smsTemplate.properties");
    		//	pps.getProperty("sms.tpmplate.checkCode.tpmplate")
			pps.load(s);
			Set keyValue = pps.keySet();
			for (Iterator<String> it = keyValue.iterator(); it.hasNext();)
			{
					String key = it.next();
					System.out.println(key);
					String [] x= key.split("\\.");
					System.out.println(x[x.length-1]);
					Field ad= SmsTemplate.class.getField(x[x.length-1]);
					//ad.
					System.out.println(key.substring(key.lastIndexOf(".")+1)); 
			}
			
//			byte[] b = s.getBytes("gbk");//±àÂë  
//	        String sa = new String(b, "gbk")
			//if()
			//System.out.println( instanceof Object);
			Enumeration a=pps.elements();
			//pps.
			//int i=0;
//			while (a.hasMoreElements()){
//				//String as= (a.nextElement() instanceof String)? (String)a.nextElement() : null;
//				  Object c=a.nextElement();
//				System.out.println(i++ +"="+(c instanceof String) ? (String)c : null);
//			} 
			if(pps.getProperty("sms.tpmplate.checkCode.tpmplate") instanceof String){
				String ss= pps.getProperty("sms.tpmplate.checkCode.tpmplate");
				System.out.println(new String(ss.getBytes("iso8859-1"), "utf-8"));	 
			}
			//pps.getProperty(key)
			pps.list(System.out);
    	
    	} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			
		}       
	}

}
