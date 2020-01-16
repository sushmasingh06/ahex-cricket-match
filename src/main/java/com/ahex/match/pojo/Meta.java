package com.ahex.match.pojo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class Meta implements Serializable{
  
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Met meta;
	
	private Inf info;
	
	private List<Map<String, Inning>> innings;


	public Met getMeta() {
		return meta;
	}

	public void setMeta(Met meta) {
		this.meta = meta;
	}

	public Inf getInfo() {
		return info;
	}

	public void setInfo(Inf info) {
		this.info = info;
	}

	public List<Map<String, Inning>> getInnings() {
		return innings;
	}

	public void setInnings(List<Map<String, Inning>> innings) {
		this.innings = innings;
	}

	@Override
	public String toString() {
		return "Meta [meta=" + meta + ", info=" + info + ", innings=" + innings
				+ "]";
	}
	

}
