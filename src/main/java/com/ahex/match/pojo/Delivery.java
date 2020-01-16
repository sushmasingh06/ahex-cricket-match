package com.ahex.match.pojo;

import java.util.Map;

public class Delivery {

	private String deliveryBall;
	private String batsman;
	private String bowler;
	private Map<String, Integer> extras;
	private String non_striker;
	private Run runs;
	private Wicket wicket;
	private Object replacements;

	

	public String getDeliveryBall() {
		return deliveryBall;
	}

	public void setDeliveryBall(String deliveryBall) {
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

	public Map<String, Integer> getExtras() {
		return extras;
	}

	public void setExtras(Map<String, Integer> extras) {
		this.extras = extras;
	}

	public String getNon_striker() {
		return non_striker;
	}

	public void setNon_striker(String non_striker) {
		this.non_striker = non_striker;
	}

	public Run getRuns() {
		return runs;
	}

	public void setRuns(Run runs) {
		this.runs = runs;
	}

	public Wicket getWicket() {
		return wicket;
	}

	public void setWicket(Wicket wicket) {
		this.wicket = wicket;
	}

	public Object getReplacements() {
		return replacements;
	}

	public void setReplacements(Object replacements) {
		this.replacements = replacements;
	}

}