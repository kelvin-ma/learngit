package com.csj.gold;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.csj.gold.mobile.model.UserInfo;
import com.csj.gold.mobile.service.UserInfoService;

//@RunWith(SpringJUnit4ClassRunner.class) //表示继承了SpringJUnit4ClassRunner类  
//@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class MyBatisTest {

	private static Logger logger =Logger.getLogger(MyBatisTest.class);
	private ApplicationContext ac=null;
	@Resource
	private UserInfoService userService = null;
	


	@Test
	public void test(){
		
		UserInfo user= userService.searchById(1);
		System.out.println(user.getUserName());
		logger.info(JSON.toJSONString(user));
	}

}
