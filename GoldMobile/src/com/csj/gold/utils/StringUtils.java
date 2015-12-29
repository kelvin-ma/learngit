package com.csj.gold.utils;

/**
 * @author Hejin
 * 
 */
public class StringUtils {
	
	/**
	 * if null or size=0 return false
	 * else return true
	 * @param str
	 * @return boolean
	 */
	public static boolean checkStringNullAndEmpty(String str){
		if(null == str || str.trim().length()==0){
			return false;
		}
		return true;
	}
	
}
