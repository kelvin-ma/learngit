package com.csj.gold.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.csj.gold.dao.TestMapper;
import com.csj.gold.model.TestOne;
import com.csj.gold.service.TestService;

@Service("testService")
public class TestServiceImpl implements TestService {

	@Resource
	TestMapper testMapper = null;

	@Override
	public List<TestOne> searchOneToOne() {
		return testMapper.searchOneToOne();
	}
	@Override
	public List<TestOne> searchOneToMore() {
		return testMapper.searchOneToMore();
	}

}
