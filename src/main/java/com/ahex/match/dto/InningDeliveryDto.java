package com.ahex.match.dto;

import java.io.Serializable;
import java.util.List;

import com.ahex.match.entities.DeliveryEntity;
import com.ahex.match.entities.InningEntity;
import com.ahex.match.pojo.Delivery;

public class InningDeliveryDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private InningEntity inning;
	
	private List<DeliveryEntity> deliveries;

	public InningEntity getInning() {
		return inning;
	}

	public void setInning(InningEntity inning) {
		this.inning = inning;
	}

	public List<DeliveryEntity> getDeliveries() {
		return deliveries;
	}

	public void setDeliveries(List<DeliveryEntity> deliveries) {
		this.deliveries = deliveries;
	}


}
