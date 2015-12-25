package com.csj.gold.mobile.common;

import java.lang.reflect.Type;
import java.sql.Timestamp;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
public class JsonConvert {

	private static JsonConvert instance;

	public static synchronized JsonConvert getInstance() {
		if (instance == null)
			instance = new JsonConvert();
		return instance;
	}

	private Gson gson;

	public JsonConvert() {
		GsonBuilder builder = new GsonBuilder().setExclusionStrategies(new MyExclusionStrategy()).serializeNulls().setDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		builder.registerTypeAdapter(Timestamp.class,
				new SqlTimestampConverter());
		builder.setPrettyPrinting().disableHtmlEscaping().create();
		gson = builder.create();
	}

	public String toJson(Object obj) {
		return gson.toJson(obj);
	}

	public Object formJson(String str, Type type) {
		return gson.fromJson(str, type);
	}

}
