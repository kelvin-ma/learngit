package com.csj.gold.service;

import java.util.List;
import java.util.Map;

import com.csj.gold.mobile.vo.MobileGoldTranParams;
import com.csj.gold.model.SysAccount;

public interface MobileMyAccountService {
	
	
	public SysAccount getUserAccountByID(Long id);
	
	public  List<SysAccount> searchAccountByUserID(Long userId);
	
	public  SysAccount searchAccount(Map<String, String> select);
	/**
	 * 检查参与交易账户余额是否充足
	 * @return
	 */
	public  boolean isBalance(MobileGoldTranParams params);
}
