package com.ahex.match.dto;

import java.io.Serializable;

public class MatchVenueDto implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String date;
	private String venue;
	private String city;
	private String competition;
	private String teams;
	//private String umpires;
	
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
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
	public String getCompetition() {
		return competition;
	}
	public void setCompetition(String competition) {
		this.competition = competition;
	}
	public String getTeams() {
		return teams;
	}
	public void setTeams(String teams) {
		this.teams = teams;
	}
	/*public String getUmpires() {
		return umpires;
	}
	public void setUmpires(String umpires) {
		this.umpires = umpires;
	}
	*/
	
	
}
