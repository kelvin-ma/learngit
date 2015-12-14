package com.csj.gold.mobile.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.csj.gold.mobile.model.UserRole;
import com.csj.gold.mobile.service.UserRoleService;

@Controller
@RequestMapping("/UserRole")
public class UserRoleController{

	private UserRole userRole;
	
	private List<UserRole> userRoleList;
	
	private int result;
	
	@Resource
	private UserRoleService userRoleService;

	@RequestMapping("/index")
	public List<UserRole> index(){
		userRoleList = userRoleService.searchByParameters(userRole);
		return userRoleList;
	}
	
	@RequestMapping("/add")  
	public String add(){
		result = userRoleService.insert(userRole);
		return "result-jsp";
	}
	
	@RequestMapping("/delete")  
	public String delete(){
		result = userRoleService.delete(userRole.getId());
		return "result-json";
	}
	
	@RequestMapping("/forbidden")  
	public String forbidden(){
		result = userRoleService.forbidden(userRole.getId());
		return "result-json";
	}
	
	public String intoUpdate(){
		userRole = userRoleService.searchById(userRole.getId());
		return "intoUpdate";
	}
	
	@RequestMapping("/update")
	public String update(){
		result = userRoleService.update(userRole);
		return "result-jsp";
	}
	
	public UserRole getUserRole(){
		return userRole;
	}
	public void setUserRole(UserRole userRole){
		this.userRole = userRole;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}

	public List<UserRole> getUserRoleList() {
		return userRoleList;
	}

	public void setUserRoleList(List<UserRole> userRoleList) {
		this.userRoleList = userRoleList;
	}
}