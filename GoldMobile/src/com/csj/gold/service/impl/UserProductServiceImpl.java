package com.csj.gold.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.csj.gold.dao.single.UserProductMapper;
import com.csj.gold.model.UserProduct;
import com.csj.gold.service.UserProductService;
import com.csj.gold.utils.page.Page;

@Service("userProductService")
public class UserProductServiceImpl implements UserProductService{
	
	@Resource
	UserProductMapper userProductMapper = null;

	@Override
	public int add(UserProduct userProduct) {
		return userProductMapper.insertSelective(userProduct);
	}

	@Override
	public int update(UserProduct userProduct) {
		return userProductMapper.updateByPrimaryKeySelective(userProduct);
	}

	@Override
	public int delete(UserProduct userProduct) {
		return userProductMapper.deleteByPrimaryKey(userProduct.getId());
	}

	@Override
	public int forbidden(UserProduct userProduct) {
		return userProductMapper.forbiddenByPrimaryKey(userProduct.getId());
	}

	@Override
	public List<UserProduct> searchByParameters(Page page,UserProduct userProduct) {
		page.setParameters(userProduct);
		List<UserProduct> returnList = userProductMapper.selectByParameters(page);
		return returnList;
	}

	@Override
	public UserProduct searchByPrimaryKey(UserProduct userProduct) {
		return userProductMapper.selectByPrimaryKey(userProduct.getId());
	}

}
