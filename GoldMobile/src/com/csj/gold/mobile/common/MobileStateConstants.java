package com.csj.gold.mobile.common;

import com.csj.gold.mobile.annotation.InterfaceEnum;

public class MobileStateConstants  {

	public enum MobileConstants  {

		UNSUCCESS("失败",3001),
		NOT_LOGIN("未登录",3002),
		UPDATE_FAULE("修改失败",3003),
		SHORT_PARAMETER("缺少参数",3004),
		WRONG_PARAMETER("错误参数",3005),
		EXIST_PHONE("已注册号码",3006),
		WRONG_PROCESS("错误流程",3007),
		WRONG_IMAGE_CODE("验证码错误",3008),
		NO_IMAGE_CODE("无验证码",3009),
		NO_USER("无用户",3010),
		ERROR("联系管理",3011),
		WRONG_PASSWORD("密码错误",3012),
		EXIST("已存在",3013),
		SUCCESS("成功",2001),
		NO_DATA("无数据",2002)
		;
		 // 成员变量
	     private String name;
	     private Integer index;

	     // 构造方法
	     private MobileConstants(String name,Integer index) {
	         this.name = name;
	         this.index = index;
	     }
	     
	     
	     // 普通方法
	     public static String getName(int index) {
	         for (InterfaceEnum c : InterfaceEnum.values()) {
	             if (c.getIndex() == index) {
	                 return c.getName();
	             }
	         }
	         return null;
	     }

	     // get set 方法
	     public String getName() {
	         return name;
	     }

	     public void setName(String name) {
	         this.name = name;
	     }

	     public int getIndex() {
	         return index;
	     }

	     public void setIndex(int index) {
	         this.index = index;
	     }
		
	}

}
