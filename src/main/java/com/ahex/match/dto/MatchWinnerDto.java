package com.ahex.match.dto;

import java.io.Serializable;

public class MatchWinnerDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String date;
	private String out_come_winner;
	private String teams;
	
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getOut_come_winner() {
		return out_come_winner;
	}
	public void setOut_come_winner(String out_come_winner) {
		this.out_come_winner = out_come_winner;
	}
	public String getTeams() {
		return teams;
	}
	public void setTeams(String teams) {
		this.teams = teams;
	}
		

}
