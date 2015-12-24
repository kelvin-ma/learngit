package com.csj.gold.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.csj.gold.dao.single.UserBankcardMapper;
import com.csj.gold.model.UserBankcard;
import com.csj.gold.service.UserBankcardService;
import com.csj.gold.utils.page.Page;

@Service("userBankcardService")
public class UserBankcardServiceImpl implements UserBankcardService{
	
	@Resource
	UserBankcardMapper userBankcardMapper = null;

	@Override
	public int add(UserBankcard userBankcard) {
		return userBankcardMapper.insertSelective(userBankcard);
	}

	@Override
	public int update(UserBankcard userBankcard) {
		return userBankcardMapper.updateByPrimaryKeySelective(userBankcard);
	}

	@Override
	public int delete(UserBankcard userBankcard) {
		return userBankcardMapper.deleteByPrimaryKey(userBankcard.getId());
	}

	@Override
	public int forbidden(UserBankcard userBankcard) {
		return userBankcardMapper.forbiddenByPrimaryKey(userBankcard.getId());
	}

	@Override
	public List<UserBankcard> searchByParameters(Page page,UserBankcard userBankcard) {
		page.setParameters(userBankcard);
		List<UserBankcard> returnList = userBankcardMapper.selectByParameters(page);
		return returnList;
	}

	@Override
	public UserBankcard searchByPrimaryKey(UserBankcard userBankcard) {
		return userBankcardMapper.selectByPrimaryKey(userBankcard.getId());
	}

}
