package com.csj.gold.mobile.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.csj.gold.mobile.model.ProductType;
import com.csj.gold.mobile.service.ProductTypeService;

@Controller
@RequestMapping("/ProductType")
public class ProductTypeController {

	private ProductType productType;

	private List<ProductType> productTypeList;

	private int result;

	@Resource
	private ProductTypeService productTypeService;

	@RequestMapping("/index")
	public List<ProductType> index() {
		productTypeList = productTypeService.searchByParameters(productType);
		return productTypeList;
	}

	@RequestMapping("/add")
	public String add() {
		result = productTypeService.insert(productType);
		return "result-jsp";
	}

	@RequestMapping("/delete")
	public String delete() {
		result = productTypeService.delete(productType.getId());
		return "result-json";
	}

	@RequestMapping("/forbidden")
	public String forbidden() {
		result = productTypeService.forbidden(productType.getId());
		return "result-json";
	}

	public String intoUpdate() {
		productType = productTypeService.searchById(productType.getId());
		return "intoUpdate";
	}

	@RequestMapping("/update")
	public String update() {
		result = productTypeService.update(productType);
		return "result-jsp";
	}

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public List<ProductType> getProductTypeList() {
		return productTypeList;
	}

	public void setProductTypeList(List<ProductType> productTypeList) {
		this.productTypeList = productTypeList;
	}
}