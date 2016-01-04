package com.csj.gold.init;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Properties;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.csj.gold.cache.MapCacheManager;

@Component("BeanDefineConfigue")
public class InitFile implements ApplicationListener<ContextRefreshedEvent> {

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		if (event.getApplicationContext().getParent() == null) { // 避免执行两次
			this.getSystempropertiesToCacheMap();
		}
	}

	private void getSystempropertiesToCacheMap() {
		Properties pps = new Properties();
		try {
			pps.load(new FileInputStream("system.properties"));
			Enumeration enum1 = pps.propertyNames();// 得到配置文件的名字
			Map<String,String> systemPropertiesMap=(Map<String,String>)MapCacheManager.getInstance().getMapCache().get("systemProperties");
			while (enum1.hasMoreElements()) {
				String strKey = (String) enum1.nextElement();
				String strValue = pps.getProperty(strKey);
				systemPropertiesMap.put(strKey, strValue);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
