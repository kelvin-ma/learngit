package com.csj.demo.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
@RequestMapping("/a")
public class DemoController {
	 @RequestMapping ("/showView" )  
	 public String index() {  
	       System.out.println("sssss");
	       return "index";  
	 }
	 @RequestMapping ("/a/{pageNo}" )  
	 public String indexx(@PathVariable("pageNo")int pageNo) {  
	       System.out.println(pageNo);
	       return "index";  
	 }
	 @RequestMapping ("/b" )  
	 public String indexxx(@RequestParam("name")String name) {  
	       System.out.println(name);
	       return "index";  
	 }
}
