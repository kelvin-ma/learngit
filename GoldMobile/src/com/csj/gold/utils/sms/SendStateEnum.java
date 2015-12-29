package com.csj.gold.utils.sms;

import com.csj.gold.mobile.annotation.InterfaceEnum;

public enum  SendStateEnum {
	NOT_SEND("未发送",-1),
	TO_SEND("待发送",2),
	SEND_SUCCESS("发送成功",1),
	SEND_FAILED("发送失败",0),
	SEND_INTERRUPT("发送中断,时间范围内发送条数受限",3),
	SEND_ERROR("发送错误",4) ;
	 // 成员变量
     private String name;
     private Integer index;

     // 构造方法
     private SendStateEnum(String name,Integer index) {
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
