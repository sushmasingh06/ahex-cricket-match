package com.ahex.match.entities;


import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="match_info_details")
public class InfEntity {

	@Id
	@Column(name="match_info_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int match_info_Id;
	
	private String city;
	private String competition;
	private String dates;
	private String gender;
	private String match_type;
	private int neutral_venue;
	
	/*@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "match_outcome_id", referencedColumnName = "match_info_outcome_id")
	private OutcomeEntity outcome;*/
	
	private String outcome_by;
	private String out_come_winner;
	private String out_come_eliminator;
	private String out_come_result;
	private String out_come_method;
	
	private String overs;
	private String player_of_match;
	private String teams;
	
	private String toss_decision;
	private String toss_winner;
	
	private String umpires;
	private String venue;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
	@JoinColumn(name = "match_innings_Id")
	private List<InningEntity> innings;
	
	/*@OneToOne(mappedBy = "info")
	private MetaEntity metaMain;*/
	
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
	public String getDates() {
		return dates;
	}
	public void setDates(String dates) {
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
	public String getPlayer_of_match() {
		return player_of_match;
	}
	public void setPlayer_of_match(String player_of_match) {
		this.player_of_match = player_of_match;
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
	public String getVenue() {
		return venue;
	}
	public void setVenue(String venue) {
		this.venue = venue;
	}
	
	public int getMatch_info_Id() {
		return match_info_Id;
	}
	public void setMatch_info_Id(int match_info_Id) {
		this.match_info_Id = match_info_Id;
	}
	public String getOutcome_by() {
		return outcome_by;
	}
	public void setOutcome_by(String outcome_by) {
		this.outcome_by = outcome_by;
	}
	public String getOut_come_winner() {
		return out_come_winner;
	}
	public void setOut_come_winner(String out_come_winner) {
		this.out_come_winner = out_come_winner;
	}
	public String getToss_decision() {
		return toss_decision;
	}
	public void setToss_decision(String toss_decision) {
		this.toss_decision = toss_decision;
	}
	public String getToss_winner() {
		return toss_winner;
	}
	public void setToss_winner(String toss_winner) {
		this.toss_winner = toss_winner;
	}
	public List<InningEntity> getInnings() {
		return innings;
	}
	public void setInnings(List<InningEntity> innings) {
		this.innings = innings;
	}
	
	public String getOut_come_eliminator() {
		return out_come_eliminator;
	}
	public void setOut_come_eliminator(String out_come_eliminator) {
		this.out_come_eliminator = out_come_eliminator;
	}
	public String getOut_come_result() {
		return out_come_result;
	}
	public void setOut_come_result(String out_come_result) {
		this.out_come_result = out_come_result;
	}
	
	public String getOut_come_method() {
		return out_come_method;
	}
	public void setOut_come_method(String out_come_method) {
		this.out_come_method = out_come_method;
	}
	
	public int getNeutral_venue() {
		return neutral_venue;
	}
	public void setNeutral_venue(int neutral_venue) {
		this.neutral_venue = neutral_venue;
	}
	@Override
	public String toString() {
		return "InfEntity [match_info_Id=" + match_info_Id + ", city=" + city
				+ ", competition=" + competition + ", dates=" + dates
				+ ", gender=" + gender + ", match_type=" + match_type
				+ ", neutral_venue=" + neutral_venue + ", outcome_by="
				+ outcome_by + ", out_come_winner=" + out_come_winner
				+ ", out_come_eliminator=" + out_come_eliminator
				+ ", out_come_result=" + out_come_result + ", out_come_method="
				+ out_come_method + ", overs=" + overs + ", player_of_match="
				+ player_of_match + ", teams=" + teams + ", toss_decision="
				+ toss_decision + ", toss_winner=" + toss_winner + ", umpires="
				+ umpires + ", venue=" + venue + ", innings=" + innings + "]";
	}
		

}
