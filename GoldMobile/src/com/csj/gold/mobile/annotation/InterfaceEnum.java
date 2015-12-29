package com.csj.gold.mobile.annotation;

public enum  InterfaceEnum {

	 CHECK_CODE("验证验证码",1001),
	 USER_REGISTER("注册",1001),
	 SEND_SMS("发送短信",1001);
	
     // 成员变量
     private String name;
     private Integer index;

     // 构造方法
     private InterfaceEnum(String name,Integer index) {
         this.name = name;
         this.index = index;
     }
     
     
     // 普通方法
     public static String getName(int index) {
         for (InterfaceEnum c : InterfaceEnum.values()) {
             if (c.getIndex() == index) {
                 return c.name;
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

