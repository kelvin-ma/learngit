package com.csj.gold.controller;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.csj.gold.model.UserBankcard;
import com.csj.gold.service.UserBankcardService;
import com.csj.gold.utils.page.Page;

@Controller
@RequestMapping("/userBankcard")
public class UserBankcardController {
	
	private int pageSize = 10;

	@Resource
	UserBankcardService userBankcardService = null;

	@RequestMapping("/add")
	public String add(@Param("userBankcard") UserBankcard userBankcard) {
		userBankcardService.add(userBankcard);
		return null;
	}

	@RequestMapping("/update")
	public String update(@Param("userBankcard") UserBankcard userBankcard) {
		userBankcardService.update(userBankcard);
		return null;
	}

	@RequestMapping("/delete")
	public String delete(@Param("userBankcard") UserBankcard userBankcard) {
		userBankcardService.delete(userBankcard);
		return null;
	}

	@RequestMapping("/forbidden")
	public String forbidden(@Param("userBankcard") UserBankcard userBankcard) {
		userBankcardService.forbidden(userBankcard);
		return null;
	}

	@RequestMapping("/searchByParameters")
	public String searchByParameters(
			@Param("userBankcard") UserBankcard userBankcard,@Param("pageNo") int pageNo) {
		Page page = Page.newBuilder(pageNo, pageSize);
		userBankcardService.searchByParameters(page,userBankcard);
		return null;
	}

	@RequestMapping("/searchByPrimaryKey")
	public String searchByPrimaryKey(
			@Param("userBankcard") UserBankcard userBankcard) {
		userBankcardService.searchByPrimaryKey(userBankcard);
		return null;
	}

}
