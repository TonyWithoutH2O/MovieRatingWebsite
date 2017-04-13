package com.movieWebsite.model;

import java.util.List;

public class Pager <T> {
	
	private int offset;
	private int size;
	private int totalSize;
	private int total;
	private List<T> allData;
	
	public int getOffset() {
		return offset;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getTotalSize() {
		return totalSize;
	}
	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<T> getAllData() {
		return allData;
	}
	public void setAllData(List<T> allData) {
		this.allData = allData;
	}
	
}
