package com.ahex.match.entities;

import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Inning_deliveries")
 public class DeliveryEntity {

	@Id
	@Column(name="delivery_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer deliveryId;
	
	@ManyToOne
	@JoinColumn(name = "deliveryInning")
	private InningEntity deliveryInning;
	
	private String deliveryBall;
	
	private String batsman;
	private String bowler;
	private String extras;
	private String non_striker;
	private String replacements;
	
	/*@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "delivery_runs_Id", referencedColumnName = "id")
	private RunEntity runs;*/
	
	private Integer run_batsman;
	private Integer run_extras;
	private Integer run_total;
	private Integer run_non_boundary;
	
	/*@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "delivery_wicket_id", referencedColumnName = "id")
	private WicketEntity wicket;*/
	
	private String wicket_kind;
	private String wicket_player_out;
	private String wicket_fielders;

	public String getReplacements() {
		return replacements;
	}

	public void setReplacements(String replacements) {
		this.replacements = replacements;
	}
	public String getBatsman() {
		return batsman;
	}

	public void setBatsman(String batsman) {
		this.batsman = batsman;
	}

	public String getBowler() {
		return bowler;
	}

	public void setBowler(String bowler) {
		this.bowler = bowler;
	}


	public String getExtras() {
		return extras;
	}

	public void setExtras(String extras) {
		this.extras = extras;
	}

	public String getNon_striker() {
		return non_striker;
	}

	public void setNon_striker(String non_striker) {
		this.non_striker = non_striker;
	}

	public Integer getRun_batsman() {
		return run_batsman;
	}

	public void setRun_batsman(Integer run_batsman) {
		this.run_batsman = run_batsman;
	}

	public Integer getRun_extras() {
		return run_extras;
	}

	public void setRun_extras(Integer run_extras) {
		this.run_extras = run_extras;
	}

	public Integer getRun_total() {
		return run_total;
	}

	public void setRun_total(Integer run_total) {
		this.run_total = run_total;
	}

	public String getWicket_kind() {
		return wicket_kind;
	}

	public void setWicket_kind(String wicket_kind) {
		this.wicket_kind = wicket_kind;
	}

	public String getWicket_player_out() {
		return wicket_player_out;
	}

	public void setWicket_player_out(String wicket_player_out) {
		this.wicket_player_out = wicket_player_out;
	}

	public String getWicket_fielders() {
		return wicket_fielders;
	}

	public void setWicket_fielders(String wicket_fielders) {
		this.wicket_fielders = wicket_fielders;
	}


	public String getDeliveryBall() {
		return deliveryBall;
	}

	public void setDeliveryBall(String deliveryBall) {
		this.deliveryBall = deliveryBall;
	}

	public InningEntity getDeliveryInning() {
		return deliveryInning;
	}

	public void setDeliveryInning(InningEntity deliveryInning) {
		this.deliveryInning = deliveryInning;
	}

	public Integer getDeliveryId() {
		return deliveryId;
	}

	public void setDeliveryId(int deliveryId) {
		this.deliveryId = deliveryId;
	}

	public Integer getRun_non_boundary() {
		return run_non_boundary;
	}

	public void setRun_non_boundary(Integer run_non_boundary) {
		this.run_non_boundary = run_non_boundary;
	}

}