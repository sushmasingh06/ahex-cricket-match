package com.ahex.match.dto;

import java.io.Serializable;
import java.util.List;

import com.ahex.match.entities.DeliveryEntity;

public class InningInfoDto implements Serializable {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    private int innings_Id;
	
	private String inningName;
	
	private String team;
	private String absent_hurt;
	
	private List<DeliveryInfoDto> deliveries;
	

	public int getInnings_Id() {
		return innings_Id;
	}

	public void setInnings_Id(int innings_Id) {
		this.innings_Id = innings_Id;
	}

	public String getInningName() {
		return inningName;
	}

	public void setInningName(String inningName) {
		this.inningName = inningName;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getAbsent_hurt() {
		return absent_hurt;
	}

	public void setAbsent_hurt(String absent_hurt) {
		this.absent_hurt = absent_hurt;
	}

	public List<DeliveryInfoDto> getDeliveries() {
		return deliveries;
	}

	public void setDeliveries(List<DeliveryInfoDto> deliveries) {
		this.deliveries = deliveries;
	}

	
}
