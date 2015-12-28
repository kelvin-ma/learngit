package com.csj.gold.init;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.csj.gold.cache.MapCacheManager;

@Component("BeanDefineConfigue") 
public class InitFile implements ApplicationListener<ContextRefreshedEvent>{
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		if(event.getApplicationContext().getParent() == null){ //避免执行两次
			
		}
	}


}
