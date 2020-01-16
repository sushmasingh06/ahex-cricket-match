package com.ahex.match.pojo;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.ahex.match.entities.InningEntity;


public class Inf {

	private String city;
	private String competition;
	private List<Date> dates;
	private String gender;
	private String match_type;
	private Outcome outcome;
	private String overs;
	private List<String> player_of_match;
	private List<String> teams;
	private Map<String,String> toss;
	private List<String> umpires;
	private String venue;
	private int neutral_venue;
	/*private List<InningEntity> innings;*/
	

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
	
	public List<Date> getDates() {
		return dates;
	}
	public void setDates(List<Date> dates) {
		this.dates = dates;
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
	public List<String> getPlayer_of_match() {
		return player_of_match;
	}
	public void setPlayer_of_match(List<String> player_of_match) {
		this.player_of_match = player_of_match;
	}
	
	public List<String> getTeams() {
		return teams;
	}
	public void setTeams(List<String> teams) {
		this.teams = teams;
	}
	
	public Map<String, String> getToss() {
		return toss;
	}
	public void setToss(Map<String, String> toss) {
		this.toss = toss;
	}
	
	public List<String> getUmpires() {
		return umpires;
	}
	public void setUmpires(List<String> umpires) {
		this.umpires = umpires;
	}
	public String getVenue() {
		return venue;
	}
	public void setVenue(String venue) {
		this.venue = venue;
	}
	
	 
	public Outcome getOutcome() {
		return outcome;
	}
	public void setOutcome(Outcome outcome) {
		this.outcome = outcome;
	}
	
	public int getNeutral_venue() {
		return neutral_venue;
	}
	public void setNeutral_venue(int neutral_venue) {
		this.neutral_venue = neutral_venue;
	}
	@Override
	public String toString() {
		return "Inf [city=" + city + ", competition=" + competition
				+ ", dates=" + dates + ", gender=" + gender + ", match_type="
				+ match_type + ", outcome=" + outcome + ", overs=" + overs
				+ ", player_of_match=" + player_of_match + ", teams=" + teams
				+ ", toss=" + toss + ", umpires=" + umpires + ", venue="
				+ venue + ", neutral_venue=" + neutral_venue + "]";
	}
		
	
}
