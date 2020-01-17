package com.ahex.match.pojo;


public class Run{
		
	private Long batsman;
	private Long extras;
	private Long total;
	private Long non_boundary;
	public Long getBatsman() {
		return batsman;
	}
	public void setBatsman(Long batsman) {
		this.batsman = batsman;
	}
	public Long getExtras() {
		return extras;
	}
	public void setExtras(Long extras) {
		this.extras = extras;
	}
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	public Long getNon_boundary() {
		return non_boundary;
	}
	public void setNon_boundary(Long non_boundary) {
		this.non_boundary = non_boundary;
	}
	@Override
	public String toString() {
		return "Run [batsman=" + batsman + ", extras=" + extras + ", total=" + total + ", non_boundary=" + non_boundary
				+ "]";
	}
	
	
	
	
	}