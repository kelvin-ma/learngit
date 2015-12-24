package com.csj.gold.controller;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.csj.gold.model.UserInfo;
import com.csj.gold.service.UserInfoService;
import com.csj.gold.utils.page.Page;

@Controller
@RequestMapping("/userInfo")
public class UserInfoController {
	
	private int pageSize = 10;

	@Resource
	UserInfoService userInfoService = null;

	@RequestMapping("/add")
	public String add(@Param("userInfo") UserInfo userInfo) {
		userInfoService.add(userInfo);
		return null;
	}

	@RequestMapping("/update")
	public String update(@Param("userInfo") UserInfo userInfo) {
		userInfoService.update(userInfo);
		return null;
	}

	@RequestMapping("/delete")
	public String delete(@Param("userInfo") UserInfo userInfo) {
		userInfoService.delete(userInfo);
		return null;
	}

	@RequestMapping("/forbidden")
	public String forbidden(@Param("userInfo") UserInfo userInfo) {
		userInfoService.forbidden(userInfo);
		return null;
	}

	@RequestMapping("/searchByParameters")
	public String searchByParameters(
			@Param("userInfo") UserInfo userInfo,@Param("pageNo") int pageNo) {
		Page page = Page.newBuilder(pageNo, pageSize);
		userInfoService.searchByParameters(page,userInfo);
		return null;
	}

	@RequestMapping("/searchByPrimaryKey")
	public String searchByPrimaryKey(
			@Param("userInfo") UserInfo userInfo) {
		userInfoService.searchByPrimaryKey(userInfo);
		return null;
	}

}
