package cn.et.mvc.lesson2.utils;

import java.util.List;
import java.util.Map;

public class PageTools {

	public PageTools(Integer curPage, Integer pageCount, Integer totalCount) {
		this.curPage = curPage;
		this.pageCount = (pageCount == null ? this.pageCount : pageCount);
		this.totalPage = (totalCount % this.pageCount == 0 ? totalCount	/ this.pageCount : totalCount / this.pageCount + 1);
		this.prePage = (curPage == 1 ? curPage : curPage - 1);
		
		
		this.nextPage = (curPage.equals(totalPage) ? totalPage : curPage + 1);
		/*int c=curPage;
		int d=totalPage;
		this.nextPage=c==d?d:c+1;*/
		
		//this.nextPage = (curPage == totalPage ? totalPage : curPage + 1);
		this.startIndex = (curPage - 1) * this.pageCount + 1;
		this.endIndex = curPage * this.pageCount;
	}

	private Integer curPage;

	private Integer prePage;

	private Integer nextPage;

	private Integer totalPage;

	private Integer totalCount;

	private Integer pageCount = 5;

	private List<Map<String, Object>> data;

	private Integer startIndex;

	private Integer endIndex;

	public Integer getEndIndex() {
		return endIndex;
	}

	public void setEndIndex(Integer endIndex) {
		this.endIndex = endIndex;
	}

	public Integer getCurPage() {
		return curPage;
	}

	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}

	public Integer getPrePage() {
		return prePage;
	}

	public void setPrePage(Integer prePage) {
		this.prePage = prePage;
	}

	public Integer getNextPage() {
		return nextPage;
	}

	public void setNextPage(Integer nextPage) {
		this.nextPage = nextPage;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getPageCount() {
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	public List<Map<String, Object>> getData() {
		return data;
	}

	public void setData(List<Map<String, Object>> data) {
		this.data = data;
	}

	public Integer getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(Integer startIndex) {
		this.startIndex = startIndex;
	}

	public static void main(String[] args) {
		PageTools name = new PageTools(3, 5, 15);
		System.out.println(name.getTotalPage());
		System.out.println(name.getCurPage());
		System.out.println(name.getPrePage());
		System.out.println("------" + name.getNextPage());
		System.out.println(name.getStartIndex());
		System.out.println(name.getEndIndex());
	}
}
