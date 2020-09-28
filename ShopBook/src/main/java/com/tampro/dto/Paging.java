package com.tampro.dto;

public class Paging {
	private int pageIndex;
	private int totalPage;
	private int offSet;
	private int numberPerPage;
	private long totalProduct;
	
	
	public Paging() {
		totalProduct = 0 ;
	}
	
	public Paging(int numberPerPage) {		
		this.numberPerPage = numberPerPage;
	}
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	public int getTotalPage() {
		totalPage  = (int) Math.ceil(totalProduct /(double) numberPerPage);
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getOffSet() {
		if(pageIndex > 0) {
			offSet  = (pageIndex - 1) * numberPerPage;
		}
		return offSet;
	}
	public void setOffSet(int offSet) {
		this.offSet = offSet;
	}
	public int getNumberPerPage() {
		return numberPerPage;
	}
	public void setNumberPerPage(int numberPerPage) {
		this.numberPerPage = numberPerPage;
	}

	public long getTotalProduct() {
		return totalProduct;
	}

	public void setTotalProduct(long totalProduct) {
		this.totalProduct = totalProduct;
	}
	
	
	
	
	

}
