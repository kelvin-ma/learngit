package com.csj.gold.mobile;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;



import com.alibaba.druid.support.logging.Log;
import com.alibaba.druid.support.logging.LogFactory;
import com.csj.gold.mobile.vo.MobileParams;
import com.google.gson.reflect.TypeToken;

/**
 * 移动接口服务注册器
 * @author kelvin
 *
 */
public class RegistTransation {
	
	
	private static final Log log = LogFactory.getLog(RegistTransation.class);
	/**
	 * 懒加载
	 * @author kelvin
	 *
	 */
	private static class  RegistTransationHolder{
		private final static RegistTransation registTransation = new RegistTransation();
	}
	
	private Map<Integer, String> transactions;
	private Map<Integer, Type> paramsTypes;

	
	
	private RegistTransation(){

		transactions = Collections.synchronizedMap(new HashMap<Integer, String>()) ;
		paramsTypes = Collections.synchronizedMap(new HashMap<Integer, Type>());
		System.out.println("只初始化一次");
	}
	
	
	/**
	 * 返回注册器实例
	 * @return
	 */
	 public static final RegistTransation getInstance(){
		 return RegistTransationHolder.registTransation;
	 }
	 
	 
    /**
     * 注册服务
     * @param tranNo 交易号
     * @param type 入惨类型
     * @param beanName 处理Service
     */
	public void  registService(Integer tranNo, Type type, String beanName){
		
		paramsTypes.put(tranNo, type);
		transactions.put(tranNo, beanName);
		System.out.println("sss");
	}


	public Map<Integer, String> getTransactions() {
		return transactions;
	}





	public Map<Integer, Type> getParamsTypes() {
		return paramsTypes;
	}


}

