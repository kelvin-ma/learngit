package com.csj.gold.controller;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.csj.gold.model.ProductTransactionsRule;
import com.csj.gold.service.ProductTransactionsRuleService;
import com.csj.gold.utils.page.Page;

@Controller
@RequestMapping("/productTransactionsRule")
public class ProductTransactionsRuleController {
	
	private int pageSize = 10;

	@Resource
	ProductTransactionsRuleService productTransactionsRuleService = null;

	@RequestMapping("/add")
	public String add(@Param("productTransactionsRule") ProductTransactionsRule productTransactionsRule) {
		productTransactionsRuleService.add(productTransactionsRule);
		return null;
	}

	@RequestMapping("/update")
	public String update(@Param("productTransactionsRule") ProductTransactionsRule productTransactionsRule) {
		productTransactionsRuleService.update(productTransactionsRule);
		return null;
	}

	@RequestMapping("/delete")
	public String delete(@Param("productTransactionsRule") ProductTransactionsRule productTransactionsRule) {
		productTransactionsRuleService.delete(productTransactionsRule);
		return null;
	}

	@RequestMapping("/forbidden")
	public String forbidden(@Param("productTransactionsRule") ProductTransactionsRule productTransactionsRule) {
		productTransactionsRuleService.forbidden(productTransactionsRule);
		return null;
	}

	@RequestMapping("/searchByParameters")
	public String searchByParameters(
			@Param("productTransactionsRule") ProductTransactionsRule productTransactionsRule,@Param("pageNo") int pageNo) {
		Page page = Page.newBuilder(pageNo, pageSize);
		productTransactionsRuleService.searchByParameters(page,productTransactionsRule);
		return null;
	}

	@RequestMapping("/searchByPrimaryKey")
	public String searchByPrimaryKey(
			@Param("productTransactionsRule") ProductTransactionsRule productTransactionsRule) {
		productTransactionsRuleService.searchByPrimaryKey(productTransactionsRule);
		return null;
	}

}
