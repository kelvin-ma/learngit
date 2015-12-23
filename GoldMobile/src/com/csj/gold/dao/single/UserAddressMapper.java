package com.csj.gold.dao.single;

import java.util.List;

import com.csj.gold.model.UserAddress;
import com.csj.gold.utils.page.Page;

public interface UserAddressMapper {
    int deleteByPrimaryKey(Long id);
    
    int forbiddenByPrimaryKey(Long id);

    int insert(UserAddress userAddress);

    int insertSelective(UserAddress userAddress);

    UserAddress selectByPrimaryKey(Long id);
    
    List<UserAddress> selectByParameters(Page page);

    int updateByPrimaryKeySelective(UserAddress userAddress);

    int updateByPrimaryKey(UserAddress userAddress);
    
	List<UserAddress> searchByUserId(UserAddress userAddress);
	
	int resetMainAddress(UserAddress userAddress);
	
	int setMainAddress(UserAddress userAddress);
    
}