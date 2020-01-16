package com.ahex.match.service;

import java.util.List;
import java.util.Map;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ahex.match.dto.FilterDto;
import com.ahex.match.dto.FinalDto;
import com.ahex.match.entities.DeliveryEntity;
import com.ahex.match.entities.InfEntity;
import com.ahex.match.entities.InningEntity;
import com.ahex.match.pojo.MAtchDeliveryDto;
import com.ahex.match.pojo.Meta;

public interface MatchService {

	void transferdataToEntity(Meta met);

	void printHello();

	List<String> getTeamName(String team);

	FinalDto getTeamInfo(FilterDto filterdto, String year, String teamName);

	FinalDto getMatchInfo(String filterType, String filterValue, FilterDto filtedto);

	
}
