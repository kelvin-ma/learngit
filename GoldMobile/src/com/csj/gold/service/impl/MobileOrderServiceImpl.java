package com.csj.gold.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.csj.gold.service.MobileOrderService;

@Service("mobileOrderService")
public class MobileOrderServiceImpl implements MobileOrderService{
	private static long beforCurrentTime = 0;
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

	@Override
	public synchronized String getNewOrderNumber() {
		return MobileOrderServiceImpl.getss();
	}
	
	public synchronized static String getss(){
		Date curTime = null;
		while(true){
			curTime = new Date();
			if(beforCurrentTime==curTime.getTime()){
				continue;
			}else{
				beforCurrentTime = curTime.getTime();
				return "or"+sdf.format(curTime)+curTime.getTime();
			}
		}
	}
	public static void main(String[] args) {
		Long st = System.currentTimeMillis();
		for(int i =0;i<100;i++){
			Thread th = new Thread(){
				public void run() {
					for(int j = 0;j<10;j++){
					MobileOrderServiceImpl s = new MobileOrderServiceImpl();
					String number = s.getNewOrderNumber();
					System.out.println(number);
					}
				};
			};
			th.start();
		}
			Long et = System.currentTimeMillis();
			System.out.println(et-st);
	}
}
