package com.csj.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DemoController {
	 @RequestMapping ( "/showView" )  
	 public ModelAndView showView() {  
	       ModelAndView modelAndView = new ModelAndView();  
	       modelAndView.setViewName( "viewName" );  
	       return modelAndView.addObject( " 需要放到 model 中的属性名称 " , " 对应的属性值，它是一个对象 " );  
	 }
}
