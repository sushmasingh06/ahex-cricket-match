package com.ahex.match.pojo;

import java.util.List;
import java.util.Map;

public class Inning {

	private String team;
	private List<Map<String,Delivery>> deliveries;
	private List<String> absent_hurt;
	

	public List<String> getAbsent_hurt() {
		return absent_hurt;
	}


	public void setAbsent_hurt(List<String> absent_hurt) {
		this.absent_hurt = absent_hurt;
	}


	public String getTeam() {
		return team;
	}


	public void setTeam(String team) {
		this.team = team;
	}

	public List<Map<String, Delivery>> getDeliveries() {
		return deliveries;
	}


	public void setDeliveries(List<Map<String, Delivery>> deliveries) {
		this.deliveries = deliveries;
	}

}
