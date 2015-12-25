package com.csj.gold.mobile.controller;

import java.lang.reflect.Type;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;



import com.alibaba.druid.support.logging.Log;
import com.alibaba.druid.support.logging.LogFactory;
import com.csj.gold.mobile.RegistTransation;
import com.csj.gold.mobile.common.JsonConvert;
import com.csj.gold.mobile.common.MobileException;
import com.csj.gold.mobile.service.IMobileTransaction;
import com.csj.gold.mobile.vo.MobileParams;
import com.csj.gold.mobile.vo.User;
import com.google.gson.reflect.TypeToken;

@Controller
@RequestMapping("/m")  
public class MobileController   {
	 private static final Log log = LogFactory.getLog(MobileController.class);
	 
	 @ResponseBody
	 @RequestMapping ("/") 
	 public String transationDistribute(Integer tranNo,String jsonStr ,HttpServletRequest request,HttpServletResponse response, HttpSession httpSession) {
		 	
	
	       return "index";   
	 }
	 
	 public void registTransation(String tranNo, Type type, String beanName) {

	 }
	 
	 public void s(){
//			Map<Integer, String> transactions= RegistTransation.getInstance().getTransactions();
//			Map<Integer, Type> paramsTypes= RegistTransation.getInstance().getParamsTypes();
//			
//			log.info("tranNo="+tranNo+"  jsonStr"+jsonStr);
//			WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(httpSession.getServletContext());
//			JsonConvert jsonConvert =JsonConvert.getInstance();
//			try {
//				MobileParams params = (MobileParams) jsonConvert.formJson(
//						jsonStr, new TypeToken<MobileParams>() {
//				}.getType());
//				//参数为空异常处理
////				if (params == null)
////					throw new MobileException(
////								MobileConstants.RESULT_CODE_PARAMS_FORMAT_ERROR,
////								MobileConstants.RESULT_CODE_PARAMS_FORMAT_ERROR_DESC);
////					
//					
//					String beanName = transactions.get(tranNo);
//					
//					
//					Object obj = null;
//					if (beanName != null)
//						obj = wac.getBean(beanName);
//					//交易类不存在异常处理
////					if (obj == null)
////						throw new MobileException(
////								MobileConstants.RESULT_CODE_TRAN_CLASS_NO_EXIST,
////								MobileConstants.RESULT_CODE_TRAN_CLASS_NO_EXIST_DESC);
//					//交易类没有实现交易接口
////					if (!(obj instanceof IMobileTransaction))
////						throw new MobileException(
////								MobileConstants.RESULT_CODE_TRAN_CLASS_NO_IMPLEMENTS,
////								MobileConstants.RESULT_CODE_TRAN_CLASS_NO_IMPLEMENTS_DESC);
//					
//					IMobileTransaction transaction = (IMobileTransaction) obj;
//					Type type = paramsTypes.get(tranNo);
//					
//					 //获取登录校验参数
////					 InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("xx.properties");
////					 Properties p = new Properties();
////					 p.load(inputStream);
////					 if(p.containsKey(transNo)){
////						 if("true".equals(p.get(transNo))){
////							 
////						 }else {
////							 throw new MobileException(
////										MobileConstants.RESULT_CODE_PARAMS_TYPE_NO_EXIST,
////										MobileConstants.RESULT_CODE_PARAMS_TYPE_NO_EXIST_DESC);
////						 }
////					 }
//					//交易参数类不存在!
////					if (type == null)
////						throw new MobileException(
////								MobileConstants.RESULT_CODE_PARAMS_TYPE_NO_EXIST,
////								MobileConstants.RESULT_CODE_PARAMS_TYPE_NO_EXIST_DESC);
//					
//					params = (MobileParams) jsonConvert.formJson(jsonStr, type);
//					
//					
//					result = transaction.doTransaction(params, request, response);
	 }
}
