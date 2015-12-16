package com.csj.gold.utils.json;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

public class MyExclusionStrategy implements ExclusionStrategy {

	private final Class<?> typeToSkip;

	public MyExclusionStrategy() {

		this.typeToSkip = null;
	}

	public MyExclusionStrategy(Class<?> typeToSkip) {
		this.typeToSkip = typeToSkip;

	}

	public boolean shouldSkipClass(Class<?> clazz) {
		return (clazz == typeToSkip);
	}

	@Override
	public boolean shouldSkipField(FieldAttributes arg0) {
		// TODO Auto-generated method stub
		return false;
	}

}
