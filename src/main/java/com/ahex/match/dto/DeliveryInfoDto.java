package com.ahex.match.dto;

import java.io.Serializable;

import com.ahex.match.entities.InningEntity;

public class DeliveryInfoDto implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

private int deliveryId;
	
	private InningEntity deliveryInning;
	
	private Float deliveryBall;
	
	private String batsman;
	private String bowler;
	private String extras;
	private String non_striker;
	private String replacements;
	
	private int run_batsman;
	private int run_extras;
	private int run_total;
	private int run_non_boundary;
	
	private String wicket_kind;
	private String wicket_player_out;
	private String wicket_fielders;
	
	public int getDeliveryId() {
		return deliveryId;
	}
	public void setDeliveryId(int deliveryId) {
		this.deliveryId = deliveryId;
	}
	public InningEntity getDeliveryInning() {
		return deliveryInning;
	}
	public void setDeliveryInning(InningEntity deliveryInning) {
		this.deliveryInning = deliveryInning;
	}
	public Float getDeliveryBall() {
		return deliveryBall;
	}
	public void setDeliveryBall(Float deliveryBall) {
		this.deliveryBall = deliveryBall;
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
	public String getReplacements() {
		return replacements;
	}
	public void setReplacements(String replacements) {
		this.replacements = replacements;
	}
	public int getRun_batsman() {
		return run_batsman;
	}
	public void setRun_batsman(int run_batsman) {
		this.run_batsman = run_batsman;
	}
	public int getRun_extras() {
		return run_extras;
	}
	public void setRun_extras(int run_extras) {
		this.run_extras = run_extras;
	}
	public int getRun_total() {
		return run_total;
	}
	public void setRun_total(int run_total) {
		this.run_total = run_total;
	}
	public int getRun_non_boundary() {
		return run_non_boundary;
	}
	public void setRun_non_boundary(int run_non_boundary) {
		this.run_non_boundary = run_non_boundary;
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
	
	
}
