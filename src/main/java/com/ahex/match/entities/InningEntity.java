package com.ahex.match.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="match_innings")
public class InningEntity {
	@Id
	@Column(name="innings_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int innings_Id;
	
	private String inningName;
	@Column(nullable = true)
	private Long total_run;
	
	private String team;
	private String absent_hurt;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
	@JoinColumn(name = "inning_delivery_id")
	private List<DeliveryEntity> deliveries;
	
	//@ManyToOne(mappedBy = "info")
	
	
	public String getTeam() {
		return team;
	}


	public Long getTotal_run() {
		return total_run;
	}


	public void setTotal_run(Long total_run) {
		this.total_run = total_run;
	}


	public String getAbsent_hurt() {
		return absent_hurt;
	}


	public void setAbsent_hurt(String absent_hurt) {
		this.absent_hurt = absent_hurt;
	}


	public void setTeam(String team) {
		this.team = team;
	}

	public String getInningName() {
		return inningName;
	}


	public void setInningName(String inningName) {
		this.inningName = inningName;
	}


	public List<DeliveryEntity> getDeliveries() {
		return deliveries;
	}


	public void setDeliveries(List<DeliveryEntity> deliveries) {
		this.deliveries = deliveries;
	}


	public int getInnings_Id() {
		return innings_Id;
	}


	public void setInnings_Id(int innings_Id) {
		this.innings_Id = innings_Id;
	}

}
