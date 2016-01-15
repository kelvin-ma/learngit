package com.csj.gold.service;

import java.util.List;

import com.csj.gold.model.TestOne;

public interface TestService {
	List<TestOne> searchOneToOne();
	List<TestOne> searchOneToMore();
}
