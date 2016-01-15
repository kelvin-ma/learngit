package com.csj.gold.model;

import java.util.List;

public class TestOne {
	private Integer id;
	private String name;

	private TestTwo testTwo;

	private List<TestTwo> testTwoList;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toStringOneToMore() {
		StringBuilder sb = new StringBuilder();
		sb.append("ID:" + this.getId() + " Name:" + this.getName());
		if (this.testTwoList != null && this.testTwoList.size() > 0) {
			for (TestTwo t : this.testTwoList) {
				sb.append("\n   " + t.getId() + "  " + t.getName() + "  "
						+ t.getPkId());
			}
		}
		return sb.toString();
	}

	public String toStringOneToOne() {
		StringBuilder sb = new StringBuilder();
		sb.append("ID:" + this.getId() + " Name:" + this.getName());
		if (this.testTwo != null) {
			sb.append("\n   " + testTwo.getId() + "  "
					+ testTwo.getName() + "  " + testTwo.getPkId());
		}
		return sb.toString();
	}

	public TestTwo getTestTwo() {
		return testTwo;
	}

	public void setTestTwo(TestTwo testTwo) {
		this.testTwo = testTwo;
	}

	public void setTestTwoList(List<TestTwo> testTwoList) {
		this.testTwoList = testTwoList;
	}

}
