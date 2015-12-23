package com.csj.gold.init;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component("BeanDefineConfigue") 
public class InitFile implements ApplicationListener<ContextRefreshedEvent>{

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		if(event.getApplicationContext().getParent() == null){ //避免执行两次
			
			//DO THE LOGIC METHOD
		}
	}

}
