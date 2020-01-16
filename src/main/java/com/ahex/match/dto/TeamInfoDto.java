package com.ahex.match.dto;

import java.io.Serializable;

/**
 * @author Sushma
 */

public class TeamInfoDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long matchCount;
	private Long playedCount;
	private String teamName;
	private Long winnerCount;
	private Long lossCount;
	
	public Long getMatchCount() {
		return matchCount;
	}
	public void setMatchCount(Long matchCount) {
		this.matchCount = matchCount;
	}
	public Long getPlayedCount() {
		return playedCount;
	}
	public void setPlayedCount(Long playedCount) {
		this.playedCount = playedCount;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public Long getWinnerCount() {
		return winnerCount;
	}
	public void setWinnerCount(Long winnerCount) {
		this.winnerCount = winnerCount;
	}
	public Long getLossCount() {
		return lossCount;
	}
	public void setLossCount(Long lossCount) {
		this.lossCount = lossCount;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "TeamInfo [matchCount=" + matchCount + ", playedCount=" + playedCount + ", teamName=" + teamName
				+ ", winnerCount=" + winnerCount + ", lossCount=" + lossCount + "]";
	}
	
	
}
