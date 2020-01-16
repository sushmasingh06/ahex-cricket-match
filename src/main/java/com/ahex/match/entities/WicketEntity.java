package com.ahex.match.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="delivery_wicket")
public class WicketEntity {
	
	@Id
	@Column(name="delivery_wicket_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int delivery_wicket_Id;
	
	private String kind;
	private String player_out;
	private String fielders;

	@OneToOne
	@JoinColumn(name = "deliverywicket")
	private WicketEntity deliverywicket;
	
	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getPlayer_out() {
		return player_out;
	}

	public void setPlayer_out(String player_out) {
		this.player_out = player_out;
	}


	public String getFielders() {
		return fielders;
	}

	public void setFielders(String fielders) {
		this.fielders = fielders;
	}

	public int getDelivery_wicket_Id() {
		return delivery_wicket_Id;
	}

	public void setDelivery_wicket_Id(int delivery_wicket_Id) {
		this.delivery_wicket_Id = delivery_wicket_Id;
	}

	public WicketEntity getDeliverywicket() {
		return deliverywicket;
	}

	public void setDeliverywicket(WicketEntity deliverywicket) {
		this.deliverywicket = deliverywicket;
	}

}
