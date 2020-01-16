package com.ahex.match.pojo;


public class Run{
		
	private Integer batsman;
	private Integer extras;
	private Integer total;
	private Integer non_boundary;
	
	public Integer getBatsman() {
		return batsman;
	}
	public void setBatsman(Integer batsman) {
		this.batsman = batsman;
	}
	public Integer getExtras() {
		return extras;
	}
	public void setExtras(Integer extras) {
		this.extras = extras;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	
	public Integer getNon_boundary() {
		return non_boundary;
	}
	public void setNon_boundary(Integer non_boundary) {
		this.non_boundary = non_boundary;
	}
	@Override
	public String toString() {
		return "Run [batsman=" + batsman + ", extras=" + extras + ", total=" + total + ", non_boundary=" + non_boundary
				+ "]";
	}
	
	
	}