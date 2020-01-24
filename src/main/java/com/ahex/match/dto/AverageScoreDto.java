package com.ahex.match.dto;

public class AverageScoreDto {

	private String match;
	private Long averageScore;
	private String groundName;
	private Long minScore;
	private Long maxScore;
	private Long matchCount;
	
	public Long getMatchCount() {
		return matchCount;
	}
	public void setMatchCount(Long matchCount) {
		this.matchCount = matchCount;
	}
	public String getMatch() {
		return match;
	}
	public void setMatch(String match) {
		this.match = match;
	}
	public Long getAverageScore() {
		return averageScore;
	}
	public void setAverageScore(Long averageScore) {
		this.averageScore = averageScore;
	}
	public String getGroundName() {
		return groundName;
	}
	public void setGroundName(String groundName) {
		this.groundName = groundName;
	}
	public Long getMinScore() {
		return minScore;
	}
	public void setMinScore(Long minScore) {
		this.minScore = minScore;
	}
	public Long getMaxScore() {
		return maxScore;
	}
	public void setMaxScore(Long maxScore) {
		this.maxScore = maxScore;
	}
}
