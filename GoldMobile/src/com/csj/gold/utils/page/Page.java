package com.csj.gold.utils.page;

import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

public class Page {

	private static final Logger logger = LoggerFactory.getLogger(Page.class);
	private static ObjectMapper mapper = new ObjectMapper();

	public static int USE_PAGE = 1;

	public static int UN_USE_PAGE = 0;

	public static String DEFAULT_PAGESIZE = "10";
	private Object parameters;
	private int pageNo; // 当前页码
	private int pageSize; // 每页行数
	private int totalRecord; // 总记录数
	private int totalPage; // 总页数
	private String pageNoDisp; // 可以显示的页号(分隔符"|"，总页数变更时更新)
	private int usePage = USE_PAGE; // 是否使用分页

	private Page() {
		pageNo = 1;
		pageSize = Integer.valueOf(DEFAULT_PAGESIZE);
		totalRecord = 0;
		totalPage = 0;
		pageNoDisp = "";
	}

	public static Page newBuilder(int pageNo, int pageSize) {
		Page page = new Page();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		return page;
	}
	
	public static Page newBuilderUnPage() {
		Page page = new Page();
		page.setPageNo(1);
		page.setPageSize(1);
		page.setUsePage(Page.UN_USE_PAGE);
		return page;
	}

	/**
	 * 总件数变化时，更新总页数并计算显示样式
	 */
	private void refreshPage() {
		// 总页数计算
		totalPage = totalRecord % pageSize == 0 ? totalRecord / pageSize
				: (totalRecord / pageSize + 1);
		// 防止超出最末页（浏览途中数据被删除的情况）
		if (pageNo > totalPage && totalPage != 0) {
			pageNo = totalPage;
		}
		pageNoDisp = computeDisplayStyleAndPage();
	}

	/**
	 * 计算页号显示样式 这里实现以下的分页样式("[]"代表当前页号)，可根据项目需求调整 [1],2,3,4,5,6,7,8..12,13
	 * 1,2..5,6,[7],8,9..12,13 1,2..6,7,8,9,10,11,12,[13]
	 */
	private String computeDisplayStyleAndPage() {
		List<Integer> pageDisplays = Lists.newArrayList();
		if (totalPage <= 11) {
			for (int i = 1; i <= totalPage; i++) {
				pageDisplays.add(i);
			}
		} else if (pageNo < 7) {
			for (int i = 1; i <= 8; i++) {
				pageDisplays.add(i);
			}
			pageDisplays.add(0);// 0 表示 省略部分(下同)
			pageDisplays.add(totalPage - 1);
			pageDisplays.add(totalPage);
		} else if (pageNo > totalPage - 6) {
			pageDisplays.add(1);
			pageDisplays.add(2);
			pageDisplays.add(0);
			for (int i = totalPage - 7; i <= totalPage; i++) {
				pageDisplays.add(i);
			}
		} else {
			pageDisplays.add(1);
			pageDisplays.add(2);
			pageDisplays.add(0);
			for (int i = pageNo - 2; i <= pageNo + 2; i++) {
				pageDisplays.add(i);
			}
			pageDisplays.add(0);
			pageDisplays.add(totalPage - 1);
			pageDisplays.add(totalPage);
		}
		return Joiner.on("|").join(pageDisplays.toArray());
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
		refreshPage();
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public String getPageNoDisp() {
		return pageNoDisp;
	}

	public void setPageNoDisp(String pageNoDisp) {
		this.pageNoDisp = pageNoDisp;
	}

	public Object getParameters() {
		return parameters;
	}

	public void setParameters(Object parameters) {
		this.parameters = parameters;
	}

	public int getUsePage() {
		return usePage;
	}

	public void setUsePage(int usePage) {
		this.usePage = usePage;
	}

}