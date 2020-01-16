package com.ahex.match.dto;

import java.io.Serializable;

/**
 * @author Sushma
 */

public class FilterDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String venue;
	private String city;
	private String date;
	private String competition;
	private String gender;
	private String match_type;
	private String overs;
	private String natural_values;
	private String teams;
	private String umpires;
	public String getVenue() {
		return venue;
	}
	public void setVenue(String venue) {
		this.venue = venue;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getCompetition() {
		return competition;
	}
	public void setCompetition(String competition) {
		this.competition = competition;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMatch_type() {
		return match_type;
	}
	public void setMatch_type(String match_type) {
		this.match_type = match_type;
	}
	public String getOvers() {
		return overs;
	}
	public void setOvers(String overs) {
		this.overs = overs;
	}
	public String getNatural_values() {
		return natural_values;
	}
	public void setNatural_values(String natural_values) {
		this.natural_values = natural_values;
	}
	public String getTeams() {
		return teams;
	}
	public void setTeams(String teams) {
		this.teams = teams;
	}
	public String getUmpires() {
		return umpires;
	}
	public void setUmpires(String umpires) {
		this.umpires = umpires;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
