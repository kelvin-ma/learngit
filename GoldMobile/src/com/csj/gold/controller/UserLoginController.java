package com.csj.gold.controller;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.csj.gold.model.UserLogin;
import com.csj.gold.service.UserLoginService;
import com.csj.gold.utils.page.Page;

@Controller
@RequestMapping("/userLogin")
public class UserLoginController {
	
	private int pageSize = 10;

	@Resource
	UserLoginService userLoginService = null;

	@RequestMapping("/add")
	public String add(@Param("userLogin") UserLogin userLogin) {
		userLoginService.add(userLogin);
		return null;
	}

	@RequestMapping("/update")
	public String update(@Param("userLogin") UserLogin userLogin) {
		userLoginService.update(userLogin);
		return null;
	}

	@RequestMapping("/delete")
	public String delete(@Param("userLogin") UserLogin userLogin) {
		userLoginService.delete(userLogin);
		return null;
	}

	@RequestMapping("/forbidden")
	public String forbidden(@Param("userLogin") UserLogin userLogin) {
		userLoginService.forbidden(userLogin);
		return null;
	}

	@RequestMapping("/searchByParameters")
	public String searchByParameters(
			@Param("userLogin") UserLogin userLogin,@Param("pageNo") int pageNo) {
		Page page = Page.newBuilder(pageNo, pageSize);
		userLoginService.searchByParameters(page,userLogin);
		return null;
	}

	@RequestMapping("/searchByPrimaryKey")
	public String searchByPrimaryKey(
			@Param("userLogin") UserLogin userLogin) {
		userLoginService.searchByPrimaryKey(userLogin);
		return null;
	}

}
