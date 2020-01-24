package com.ahex.match.dao;



import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.ahex.match.dto.FilterDto;
import com.ahex.match.dto.FinalDto;
import com.ahex.match.dto.ScoreFilterDto;
import com.ahex.match.entities.InfEntity;
import com.ahex.match.entities.InningEntity;

public interface MatchInfoDAO {

	public void saveMatchInfo(InfEntity mainEntity);

	public  List<String> getTeamName(String team);

	public List<String> getUniqueTeamNames(FilterDto filterdto);

	public Long getPlayedMatch(FilterDto filterdto);

	public Long getPlayedMatchCount(String teamNames, FilterDto filterdto);

	public Map<String, Long> getTeamwiseWinCount(FilterDto filterdto);

	public List<InfEntity> getAllMatchesByParameter(FilterDto filderdto);

	public List<InfEntity> getMatchData();

	public Map<String, Long> getVenuAndMatchCountMap();

	public List<InfEntity> listOfMatchByFilterType(String venue, String filterType);

	public List<InfEntity> MatchByTeam(String team);

	
}
