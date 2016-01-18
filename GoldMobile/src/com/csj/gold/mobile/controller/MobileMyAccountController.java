package com.csj.gold.mobile.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/myaccount",produces="text/html;charset=UTF-8")
public class MobileMyAccountController {
	@SuppressWarnings("unused")
	private static Logger logger = Logger.getLogger(MobileMyAccountController.class);

}
