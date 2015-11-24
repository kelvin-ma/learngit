package com.csj.gold.mobile.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/a")
public class IndexController {
	 @RequestMapping ("/showView" )  
	 public String index() {  
	       System.out.println("sssss");
	       
	       return "index";  
	 }
	 @RequestMapping ("/m" )  
	 public String indexx(@PathVariable("No")int pageNo) {  
	       System.out.println(pageNo);
	       return "index";  
	 }
	 @RequestMapping ("/b" )  
	 public String indexxx(@RequestParam("name")String name) {  
	       System.out.println(name);
	       return "index";  
	 }
}