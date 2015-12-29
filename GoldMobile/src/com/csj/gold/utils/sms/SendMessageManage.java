package com.csj.gold.utils.sms;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.druid.support.logging.Log;
import com.alibaba.druid.support.logging.LogFactory;
import com.csj.gold.mobile.annotation.InterfaceEnum;
import com.csj.gold.utils.CheckCodeUilis;


/**
 * 发送短信信息管理器
 * 进行短信信息的管理
 * @author kelvin
 *
 */
public class SendMessageManage {
	
	private static final Log log = LogFactory.getLog(SendMessageManage.class);
	
	private Map<String, SendMessage> sendMessageMap ;
	/**
	 * 懒加载
	 * @author kelvin
	 *
	 */
	private static class  SendMessageManageHolder{
		private final static SendMessageManage instance = new SendMessageManage();
	}
	
	private SendMessageManage(){
		sendMessageMap=new HashMap<String, SendMessage>();
	}
	

	/**
	 * 
	 * 获取实例
	 * @return
	 */
	public static final SendMessageManage getInstance(){
		return SendMessageManageHolder.instance;
	}
	/**
	 * 发送短信
	 * 首次至今发送时间间隔=本次发送时间-上次发送时间 +上次发送时间间隔
	 * @param phone
	 * @param sms
	 * @return
	 */
	public SendMessage sendMessage(String phone,InterfaceEnum sms){
		System.out.println(phone+sms);
		
		String code = phone+sms;
		//上一条短信
		SendMessage lastMessage =sendMessageMap.get(code);
		//本次短信内容
		SendMessage sMessage=null;
		//第一次发送，初始化
		if(lastMessage==null){
			sMessage=new SendMessage();
			sMessage.setSendTime(System.currentTimeMillis());
			sMessage.setNextSendTime(0L);
			sMessage.setNum(0);
			sMessage.setTimeInterval(0L);
			//由于没有上次发送，所以上次发送等同于本次发送
			lastMessage=sMessage;
		}
		
		//校验是否可以发送
		SendStateEnum isSendsms=isSendSms(lastMessage);
		//不能发送
		if(SendStateEnum.SEND_INTERRUPT==isSendsms){
			sMessage = lastMessage;
			sMessage.setStateEnum(SendStateEnum.SEND_INTERRUPT);
			sendMessageMap.put(code, sMessage);
			return sMessage;
		}
		
		//装配发送参数
		if(sMessage!=null){
			sMessage.setPhone(phone);
			String smsCode=	CheckCodeUilis.numberChenKCode(4);
			sMessage.setSmsCode(smsCode);
			sMessage.setSendTime(System.currentTimeMillis());
			sMessage.setNextSendTime(System.currentTimeMillis()+59*1000);
		}
		
		
		int i=0;
		do{
			SendStateEnum  un=  SmsSendUilt.sendSmsCheckCode(sMessage);
			i++;
			if(i>5) {
				i=0;
				return sMessage ;
			}
			if(SendStateEnum.SEND_SUCCESS==sMessage.getStateEnum()){
				sendMessageMap.put(code, sMessage);
				return sMessage;
			}
		}while(SendStateEnum.SEND_SUCCESS!=sMessage.getStateEnum());
	
		//首次至今发送时间间隔=本次发送时间-上次发送时间 +上次发送时间间隔
		return sMessage;
	}
	/**
	 * 检查短信是否可以发送
	 * 
	 * 验证规则:
	 * 条数大于等于限制条数的时候，要求时间限制 ，发送时间间隔大于（发送时间范围+等待时间范围）重置已发送条数为零
	 * 首次至今发送时间间隔=本次发送时间-上次发送时间 +上次发送时间间隔
	 * @param lastMessage
	 * @return
	 */
	private SendStateEnum isSendSms(SendMessage lastMessage){
		
		int maxNum=5;
		//每条发送等待时间间隔
		Long timeInterval = 1*59*1000L;
		//超过条数后等待时间间隔
		Long waitingInterval = 5*60*1000L;
		//发送maxNum以内的时间范围 
		Long minInterval = 5*60*1000L;
		//本次发送时间
		Long sendTime = System.currentTimeMillis();
		//最后一次发送时间
		Long lastSendTime = lastMessage.getSendTime();
		//最后一次至第一次发送时间间隔
		Long  lastTimeInterval = lastMessage.getTimeInterval();
		//截止最后一次发送的发送条数总和
		Integer  lastNum = lastMessage.getNum();
		//下一次发送时间
		Long nextSendTime = lastMessage.getNextSendTime();
		//为空默认为首次发送
		if(lastSendTime==null){
			lastSendTime=sendTime;
		}
		//为空默认为首次发送
		if(lastTimeInterval==null){
			lastTimeInterval=0L;
		}
		
		if(nextSendTime==null){
			nextSendTime=0L;
		}
		
		if(lastNum==null){
			lastNum=0;
		}
		
		
		if(sendTime<nextSendTime){
			return SendStateEnum.SEND_INTERRUPT;
		}
			
		//首次至今发送时间间隔
		Long  sumTimeInterval= sendTime-lastSendTime+lastTimeInterval;
		//条数小于要求条数的时候 ，可以发送
		if(lastNum<maxNum&&sendTime>nextSendTime){
			lastMessage.setNextSendTime(sendTime+timeInterval);
			return SendStateEnum.TO_SEND;
		}
		
		//条数大于等于条数限制的时候，要求时间限制 ，发送时间间隔大于（发送时间范围+等待时间范围）重置已发送条数为零
		if(lastNum>=maxNum&&sumTimeInterval>(waitingInterval+minInterval)){
			lastMessage.setNum(0);
			lastMessage.setTimeInterval(0L);
			lastMessage.setNextSendTime(sendTime+timeInterval);
			return SendStateEnum.TO_SEND;
		}
		//设置限定发送时间 ，大于当前时间可以发送短信
		lastMessage.setNextSendTime(waitingInterval+minInterval);
		return SendStateEnum.SEND_INTERRUPT;
	}

	/**
	 * 获取发送短信管理器
	 * @return
	 */
	public Map<String, SendMessage> getSendMessageMap() {
		return sendMessageMap;
	}


	public void setSendMessageMap(Map<String, SendMessage> sendMessageMap) {
		this.sendMessageMap = sendMessageMap;
	}
	
	
}
