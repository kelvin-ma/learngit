package com.csj.gold.mobile.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.csj.gold.mobile.vo.MobileParams;
import com.csj.gold.mobile.vo.MobileResult;








public interface IMobileTransaction {
	public MobileResult doTransaction(MobileParams params, HttpServletRequest req,
			HttpServletResponse resp);
}
