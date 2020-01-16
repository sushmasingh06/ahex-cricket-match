package com.ahex.match.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "delivery_runs")
public class RunEntity {

	@Id
	@Column(name = "delivery_runs_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int delivery_runs_Id;

	@OneToOne
	@JoinColumn(name = "DeliveryRun")
	private RunEntity DeliveryRun;

	private int batsman;
	private int extras;
	private int total;

	public int getBatsman() {
		return batsman;
	}

	public void setBatsman(int batsman) {
		this.batsman = batsman;
	}

	public int getExtras() {
		return extras;
	}

	public void setExtras(int extras) {
		this.extras = extras;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getDelivery_runs_Id() {
		return delivery_runs_Id;
	}

	public void setDelivery_runs_Id(int delivery_runs_Id) {
		this.delivery_runs_Id = delivery_runs_Id;
	}

	public RunEntity getDeliveryRun() {
		return DeliveryRun;
	}

	public void setDeliveryRun(RunEntity deliveryRun) {
		DeliveryRun = deliveryRun;
	}
	
	
}