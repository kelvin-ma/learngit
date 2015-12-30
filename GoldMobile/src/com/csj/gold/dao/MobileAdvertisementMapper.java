package com.csj.gold.dao;

import java.util.List;

import com.csj.gold.model.bean.MobileAdvertisement;
import com.csj.gold.utils.page.Page;

public interface MobileAdvertisementMapper {
	List<MobileAdvertisement> searchAll();
}
