package com.csj.gold.mobile.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.csj.gold.mobile.model.ProductInfo;
import com.csj.gold.mobile.service.ProductInfoService;

@Controller
@RequestMapping("/ProudctInfo")
public class ProductInfoController {

	private ProductInfo productInfo;

	private int result;

	private List<ProductInfo> productInfoList;

	@Resource
	private ProductInfoService productInfoService;

	@RequestMapping("/index")
	public List<ProductInfo> index() {
		productInfoList = productInfoService.searchByParameters(productInfo);
		return productInfoList;
	}

	@RequestMapping("/add")
	public String add() {
		result = productInfoService.insert(productInfo);
		return "result-jsp";
	}

	@RequestMapping("/delete")
	public String delete() {
		result = productInfoService.delete(productInfo.getId());
		return "result-json";
	}

	@RequestMapping("/forbidden")
	public String forbidden() {
		result = productInfoService.forbidden(productInfo.getId());
		return "result-json";
	}

	@RequestMapping("/intoUpdate")
	public String intoUpdate() {
		productInfo = productInfoService.searchById(productInfo.getId());
		return "intoUpdate";
	}

	@RequestMapping("/update")
	public String update() {
		result = productInfoService.update(productInfo);
		return "result-jsp";
	}

	public ProductInfo getSysProduct() {
		return productInfo;
	}

	public void setSysProduct(ProductInfo productInfo) {
		this.productInfo = productInfo;
	}

	public ProductInfo getProductInfo() {
		return productInfo;
	}

	public void setProductInfo(ProductInfo productInfo) {
		this.productInfo = productInfo;
	}

	public List<ProductInfo> getProductInfoList() {
		return productInfoList;
	}

	public void setProductInfoList(List<ProductInfo> productInfoList) {
		this.productInfoList = productInfoList;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

}