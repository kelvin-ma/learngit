package com.csj.gold.utils;

import java.util.Random;

/**
 * 验证码工机类
 * @author kelvin
 * @version 1.0。0
 */
public class CheckCodeUilis {
	/**
	 * 默认大小
	 */
	private static final Integer SIZE=4;
	
	private static final Integer MAX_SIZE=19;
	
	private static final Integer MIX_SIZE=1;
	/**
	 * 获取数字随机验证码
	 * 
	 * @param length 验证码长度为空默认大小是4 最大长度19 最小长度1
	 * @return
	 */
	public static String numberChenKCode(Integer length){
		
		if(length==null||length<MIX_SIZE){
			length=SIZE;
		}
		if(length>MAX_SIZE){
			new Exception("The length of the verification code can not exceed the maximum value");
		}
		
		Random random =new Random();
		Long randomNumber= random.nextLong();
		String randomNumberStr =randomNumber.toString();
		String numStr= randomNumberStr.substring(randomNumberStr.length()-length, randomNumberStr.length());
		return numStr;
	}

}
