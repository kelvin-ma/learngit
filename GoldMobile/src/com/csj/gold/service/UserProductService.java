package com.csj.gold.service;

import java.util.List;

import com.csj.gold.model.UserProduct;
import com.csj.gold.utils.page.Page;

public interface UserProductService {
	int add(UserProduct userProduct);

	int update(UserProduct userProduct);

	int delete(UserProduct userProduct);

	int forbidden(UserProduct userProduct);

	List<UserProduct> searchByParameters(Page page,UserProduct userProduct);

	UserProduct searchByPrimaryKey(UserProduct userProduct);
}
