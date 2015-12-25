package com.csj.gold.mobile.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Type;

import com.csj.demo.common.T;
import com.csj.gold.mobile.vo.MobileParams;
/**
 * 用于注册移动服务
 * @author kelvin
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface MobileTranRegist {
    
	int tranNo() default 0000;//交易号
    
	
	Class<? extends MobileParams> classType();
}
