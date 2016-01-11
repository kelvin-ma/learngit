package com.csj.gold.service;

import java.util.List;

import com.csj.gold.model.SysAdvertisement;
import com.csj.gold.utils.page.Page;

public interface SysAdvertisementService {
	int add(SysAdvertisement sysAdvertisement);

	int update(SysAdvertisement sysAdvertisement);

	int delete(SysAdvertisement sysAdvertisement);

	int forbidden(SysAdvertisement sysAdvertisement);

	List<SysAdvertisement> searchByParameters(Page page,SysAdvertisement sysAdvertisement);

	SysAdvertisement searchByPrimaryKey(SysAdvertisement sysAdvertisement);
}