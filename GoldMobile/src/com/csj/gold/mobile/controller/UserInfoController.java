package com.csj.gold.mobile.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.csj.gold.mobile.common.MobileConstants;
import com.csj.gold.mobile.vo.MobileRegisterParams;
import com.csj.gold.mobile.vo.MobileResult;
import com.csj.gold.utils.CheckCodeUilis;
import com.csj.gold.utils.sms.SendMessageRequest;

import com.csj.gold.utils.sms.SmsSendUilt;
import com.google.gson.Gson;



@Controller
@RequestMapping("/user")
public class UserInfoController {
	
	 //private UserLogin 
	 //String  phonex="18611602272,13041258240,13810046943,13522878642,13426150962,18515913245,15801509799";

	 private  enum UserInfoEnum{
		 checkCode,register
	 }
	 /**
	  * 
	  * @return
	  */
     @ResponseBody
	 @RequestMapping ("/register" )  
	 public String register() {  
    	
    	 
    	 
	       System.out.println("sssss");
	       return "index";  
	 }
	 /**
	  * 发送验证码    
	  * 获取发送短信号码手机号，
	  * 生成验证码 ，获取相关短息文本模板  ,替换相关文字 ,发送短信验证码   （只保存最后一条发送的验证码 +计时器+计数器）
	  * 如果发送成功  验证码 存入Session中(后期放入缓存)， 并保存发送时间  存为    List<SendMessageRequest>  
	  * 由于短信验证码 对应多种业务 ，所以每个业务的验证码需要独立存储  ，需要考虑缓存中的验证码标示（如果存入缓存  建议使用  手机号+业务标示为 Key  ）   ，需要考虑验证码重复情况  
	  * 
	  * 短信验证码校验规则:一定时间内 限制发送指定条数 ，超过则需要等待一定时间才可以再继续发送  
	  * 
	  * 返回json  json状态 :成功  发送失败  参数校验失败
	  * @param params  参数列表
	  * @param session 
	  * @return
	  */
     @ResponseBody
	 @RequestMapping ("/sendCheckCode" )        
	 public String sendCheckCode(MobileRegisterParams params ,HttpSession session) {
    	 
       String phone = params.getPhone();
    	 
       Map<String, List<SendMessageRequest>> checkCodeMap=(Map<String, List<SendMessageRequest>>)session.getAttribute(UserInfoEnum.checkCode.toString());
       if(checkCodeMap==null){
    	    checkCodeMap=new HashMap<String, List<SendMessageRequest>>();
       }       
       
      
	   String checkCode= CheckCodeUilis.numberChenKCode(4);
	   
	   List<SendMessageRequest> cs=new ArrayList<SendMessageRequest>() ;
	   
	   SendMessageRequest messageRequest=new SendMessageRequest();
	   messageRequest.setPhone(params.getPhone());
	   messageRequest.setSendTime(System.currentTimeMillis()+"");
	   messageRequest.setContent(checkCode);
	   cs.add(messageRequest);

	   checkCodeMap.put(UserInfoEnum.register.toString(), cs);
	   //?需要考慮發送失敗的問題，并给与相关提示
	   SmsSendUilt.sendSmsCheckCode(phone, checkCode);
   	   
	   if(false){
		  // 短信发送失败
		 String sx=  MobileConstants.RESULT_CODE_SEND_CHECKCODE;
		 String xa=  MobileConstants.RESULT_CODE_SEND_CHECKCODE_DESC;
       }
	   
	   session.setAttribute(UserInfoEnum.checkCode.toString(), checkCodeMap);
   	   
	   MobileResult  result=new MobileResult();
	   result.setResultCode(MobileConstants.RESULT_CODE_SUCCESS);
	   result.setResultDesc(MobileConstants.RESULT_CODE_SUCCESS_DESC);
	   
	   Gson gson= new Gson();
       return gson.toJson(result);
	 }
     
     
     /**
      * 校验短信验证码 
      * 
      * 需要获取   业务线     手机号     验证码   
      * 从session 中取出当前用户当前业务线得全部验证码，用list的大小判断短信条数 如果>= 指定条数 需要校验这几条的时间间隔(使用最后一条时间 -第一条时间得到时间差) 使用计数器 或者每次取头两条时间进行记录
      * 如果如果再时间间隔内 达到限制  需等待一定时间  （此逻辑建议由APP端添加） 
      * 
      * 返回  校验成功  ，校验失败 
      * 
      * @param params
      * @param session
      * @return
      */
     @ResponseBody
	 @RequestMapping ("/checkCode" )        
	 public String checkCode(MobileRegisterParams params ,HttpSession session) {
    	 Gson gson= new Gson();
    	 MobileResult  result=new MobileResult();
    	 result.setResultCode(MobileConstants.RESULT_CODE_CHECKCODE);
       	 result.setResultDesc(MobileConstants.RESULT_CODE_CHECKCODE_DESC);
    	 String checkCode = params.getCheckCode();	 
    	  Map<String, List<SendMessageRequest>> checkCodeMap=(Map<String, List<SendMessageRequest>>)session.getAttribute(UserInfoEnum.checkCode.toString());
          if(checkCodeMap==null){
       	    checkCodeMap=new HashMap<String, List<SendMessageRequest>>();
          }     
    	 List<SendMessageRequest>  messgeRequest =  checkCodeMap.get(UserInfoEnum.register.toString());  
	     if(messgeRequest==null||messgeRequest.size()==0){
			   result.setResultCode(MobileConstants.RESULT_CODE_CHECKCODE);
			   result.setResultDesc(MobileConstants.RESULT_CODE_CHECKCODE_DESC);
			   return gson.toJson(result);
	     }

	     if(params.getCheckCode()==null||messgeRequest.size()==0){
	    	 return gson.toJson(result);
	     }                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
	  
	     for(SendMessageRequest messge:messgeRequest){
		   if(messge.getContent().equals(checkCode)){
			   result.setResultCode(MobileConstants.RESULT_CODE_SUCCESS);
			   result.setResultDesc(MobileConstants.RESULT_CODE_SUCCESS_DESC);
			   checkCodeMap.remove(UserInfoEnum.register.toString());
			   return gson.toJson(result);
		   }   
	     }
	 
	     return gson.toJson(result);
	 }
}
 