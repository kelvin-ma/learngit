package com.csj.gold.dao;

import java.util.List;

import com.csj.gold.model.TestOne;

public interface TestMapper {
	List<TestOne> searchOneToMore();

	List<TestOne> searchOneToOne();
}
