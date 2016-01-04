package com.csj.gold.utils;

import java.util.Map;

import com.csj.gold.cache.MapCacheManager;

public class SystemPropertiesUtils {

	public static Map<String, String> sysMap;

	@SuppressWarnings("unchecked")
	public static String getSystemProperties(String key) {
		if (StringUtils.checkStringNullAndEmpty(key)) {
			try {
				sysMap = (Map<String, String>) MapCacheManager.getInstance()
						.getMapCache().get(StaticValues.SYSTEM_PROPERTIES_FILE);
				return sysMap.get(key);
			} catch (Exception e) {
				return null;
			}
		} else {
			return null;
		}
	}

}
