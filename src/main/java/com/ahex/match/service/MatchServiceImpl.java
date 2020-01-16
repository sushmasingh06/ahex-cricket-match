package com.ahex.match.service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Hibernate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ahex.match.dao.MatchInfoDAO;
import com.ahex.match.dto.FilterDto;
import com.ahex.match.dto.FinalDto;
import com.ahex.match.dto.InningInfoDto;
import com.ahex.match.dto.MatchInfoDto;
import com.ahex.match.dto.TeamInfoDto;
import com.ahex.match.entities.DeliveryEntity;
import com.ahex.match.entities.InfEntity;
import com.ahex.match.entities.InningEntity;
import com.ahex.match.pojo.Delivery;
import com.ahex.match.pojo.Inf;
import com.ahex.match.pojo.Inning;
import com.ahex.match.pojo.MAtchDeliveryDto;
import com.ahex.match.pojo.Meta;
import com.ahex.match.pojo.Outcome;
import com.ahex.match.pojo.Wicket;



@Service
@Transactional
public class MatchServiceImpl implements MatchService {

	@Autowired
	MatchInfoDAO matchInfoDao;
	
	public void transferdataToEntity(Meta met) {

		Inf info = met.getInfo();
		

		List<Map<String, Inning>> innings = met.getInnings();

		//
		//MetEntity metentity = new MetEntity();
		InfEntity infentity = new InfEntity();
		//InningEntity inningentity = new InningEntity();

	/*	// Met Transfer
		metentity.setCreated(meta.getCreated());
		metentity.setData_version(meta.getData_version());
		metentity.setRevision(meta.getRevision());
		mainEntity.setMeta(metentity);*/

		// inf transer
		infentity.setCity(info.getCity());
		infentity.setCompetition(info.getCompetition());
		infentity.setDates(info.getDates().toString());
		infentity.setGender(info.getGender());
		infentity.setMatch_type(info.getMatch_type());
		infentity.setNeutral_venue(info.getNeutral_venue());
		
		// outcome inside inf
		Outcome outcome = info.getOutcome();
		//OutcomeEntity outcomeEntity = new OutcomeEntity();
		
		
		
		infentity.setOut_come_winner(outcome.getWinner());
		infentity.setOutcome_by(outcome.getBy().toString());
		if(null != outcome.getEliminator())
			infentity.setOutcome_by(outcome.getEliminator());
		if(null != outcome.getResult())
			infentity.setOutcome_by(outcome.getResult());
		if(null != outcome.getMethod())
			infentity.setOutcome_by(outcome.getMethod());
		
		
		//Map<String, String> toss=info.getToss();
		for(Map.Entry<String, String> t: info.getToss().entrySet() ) {
			t.getKey();
			if(t.getKey().equalsIgnoreCase("decision"))
				infentity.setToss_decision(t.getValue());
			if(t.getKey().equalsIgnoreCase("winner"))
				infentity.setToss_winner(t.getValue());
		}
		
		/*outcomeEntity.setRuns(outcome.getBy().toString().split("=")[1].replaceAll("//", " "));
		outcomeEntity.setWinner(outcome.getWinner());
		 infentity.setOutcome(outcomeEntity);*/

		// inf transfer continued
		// System.out.print("--------/////////-" +info.getOvers());
		if(info.getOvers()!=null)
			infentity.setOvers(info.getOvers());
		infentity.setPlayer_of_match(info.getPlayer_of_match().toString());
		infentity.setTeams(info.getTeams().toString());
		
		infentity.setUmpires(info.getUmpires().toString());
		infentity.setVenue(info.getVenue());
		//mainEntity.setInfo(infentity);

		// innings transfer
		List<InningEntity> inninglist = new ArrayList<InningEntity>();
		for (Map<String, Inning> map : innings) {
			for (Map.Entry<String, Inning> singleMap : map.entrySet()) {
				Inning inning = singleMap.getValue();
				InningEntity inningEntity = new InningEntity();

				inningEntity.setTeam(inning.getTeam());
				inningEntity.setInningName(singleMap.getKey());
				if(null != inningEntity.getAbsent_hurt())
				   inningEntity.setAbsent_hurt(inning.getAbsent_hurt().toString());
				
				
				// inningEntity.setDeliveries(inning.getDeliveries());
				List<Map<String, Delivery>> deliveryMapList = inning
						.getDeliveries();
				List<DeliveryEntity> deliverylist = new ArrayList<DeliveryEntity>();
				for (Map<String, Delivery> deliveryM : deliveryMapList) {
					for (Map.Entry<String, Delivery> deliveryMap : deliveryM
							.entrySet()) {
						Delivery delivery = deliveryMap.getValue();
						DeliveryEntity deliveryEntity = new DeliveryEntity();
						
						if(null !=delivery.getDeliveryBall())
							deliveryEntity.setDeliveryBall(deliveryMap.getKey().toString());
               
						if(null !=delivery.getBatsman() )	
							deliveryEntity.setBatsman(delivery.getBatsman());
						
						if(null != delivery.getBowler())
							deliveryEntity.setBowler(delivery.getBowler());
						
						if(null != delivery.getNon_striker())
							deliveryEntity.setNon_striker(delivery.getNon_striker());
						if(null != delivery.getExtras())
							deliveryEntity.setExtras(delivery.getExtras().toString());
						if(null != delivery.getReplacements())
							deliveryEntity.setExtras(delivery.getReplacements().toString());

						if(null != delivery.getRuns()){
							if(null!= delivery.getRuns().getBatsman())
								deliveryEntity.setRun_batsman(delivery.getRuns().getBatsman());
							if(null!=delivery.getRuns().getExtras())
								deliveryEntity.setRun_extras(delivery.getRuns().getExtras());
							if(null!=delivery.getRuns().getTotal())
								deliveryEntity.setRun_total(delivery.getRuns().getTotal());
							if(null!=delivery.getRuns().getNon_boundary())
								deliveryEntity.setRun_non_boundary(delivery.getRuns().getNon_boundary());
						}
						
						
						/*Run run = delivery.getRuns();
						RunEntity runEntity = new RunEntity();*/
						

						/*runEntity.setBatsman(run.getBatsman());
						runEntity.setExtras(run.getExtras());
						runEntity.setTotal(run.getTotal());
						if(null != runEntity)
							deliveryEntity.setRuns(runEntity);*/

						Wicket wicket = delivery.getWicket();
						

						if(null != wicket ){
							if(null != wicket.getKind())
								deliveryEntity.setWicket_kind(delivery.getWicket().getKind());
							if(null != wicket.getPlayer_out())
								deliveryEntity.setWicket_player_out(delivery.getWicket().getPlayer_out());
							if(null !=wicket.getFielders() )
								deliveryEntity.setWicket_fielders(delivery.getWicket().getFielders().toString());
							//deliveryEntity.setWicket(wicketEntity);
						}
						

						deliverylist.add(deliveryEntity);
					}

				}
				inningEntity.setDeliveries(deliverylist);
				inninglist.add(inningEntity);
			}
		}
		//mainEntity.setInnings(inninglist);
		infentity.setInnings(inninglist);

		matchInfoDao.saveMatchInfo(infentity);
	}

	public void printHello() {
		
	}
	

	/*get team Names*/
	@Override
	public List<String> getTeamName(String team) {
		
		return matchInfoDao.getTeamName(team);
	}


	/*   ****************************************************************************************    */
	
	/*@Override
	public FinalDto getTeamInfo(String year, String teamName) {
		
		List<TeamInfoDto> teamDtoList = new ArrayList<>();
		if(year != null){
			
			if(teamName != null){
				
			}else{
				Long matchcount=matchInfoDao.getPlayedMatch(year);
				Map<String, Long> teamWinCountMap = matchInfoDao.getTeamwiseWinCount(year);
				List<String> uniqueTeamNames = matchInfoDao.getUniqueTeamNames(year);
				for(String uniqueName : uniqueTeamNames){
					TeamInfoDto teamDto = new TeamInfoDto();
					teamDto.setMatchCount(matchcount);
					Long teamPlayedCount=matchInfoDao.getPlayedMatchCount(uniqueName, year);
					teamDto.setPlayedCount(teamPlayedCount);
					if(teamWinCountMap.containsKey(uniqueName)){
						teamDto.setWinnerCount(teamWinCountMap.get(uniqueName));
						teamDto.setLossCount(teamPlayedCount - teamWinCountMap.get(uniqueName));
						teamDto.setTeamName(uniqueName);
					}
					teamDtoList.add(teamDto);
				}
			} 
		}else{
			Long matchcount=matchInfoDao.getPlayedMatch(year);
			Map<String, Long> teamWinCountMap = matchInfoDao.getTeamwiseWinCount(year);
			List<String> uniqueTeamNames = matchInfoDao.getUniqueTeamNames(year);
				for(String uniqueName : uniqueTeamNames){
					TeamInfoDto teamDto = new TeamInfoDto();
					teamDto.setMatchCount(matchcount);
					Long teamPlayedCount=matchInfoDao.getPlayedMatchCount(uniqueName, year);
					teamDto.setPlayedCount(teamPlayedCount);
					if(teamWinCountMap.containsKey(uniqueName)){
						teamDto.setWinnerCount(teamWinCountMap.get(uniqueName));
						teamDto.setLossCount(teamPlayedCount - teamWinCountMap.get(uniqueName));
						teamDto.setTeamName(uniqueName);
					}
					teamDtoList.add(teamDto);
				}
			System.out.println(uniqueTeamNames);
		}
		FinalDto finalDto = new FinalDto();
		finalDto.setResult(teamDtoList);
		return finalDto;
	}*/

	@Override
	public FinalDto getMatchInfo(String filterType, String filterValue, FilterDto filderdto) {
		List<InfEntity> matchList=matchInfoDao.getAllMatchesByParameter(filderdto);
		//List<InfEntity> matchList = matchInfoDao.getAllMatches(filterType,filterValue);
		List<MatchInfoDto> matchInfoDtoList = new  ArrayList<>();
		for(InfEntity match : matchList) {
			MatchInfoDto matchInfoDto = new MatchInfoDto();
			Hibernate.initialize(match.getInnings());
		    List<InningEntity> innings = match.getInnings();
		    List<InningInfoDto> inningInfoDtoList = new ArrayList<>();
		
		 BeanUtils.copyProperties(match, matchInfoDto);
		    matchInfoDto.setInnings(inningInfoDtoList);
		    
		    matchInfoDtoList.add(matchInfoDto);
		}
		FinalDto result = new FinalDto();
		result.setResult(matchInfoDtoList);
		
		return result;
	}

	@Override
	public FinalDto getTeamInfo(FilterDto filterdto, String year, String teamName) {
		
		List<TeamInfoDto> teamDtoList = new ArrayList<>();
		
		if(filterdto != null) {
			Long matchcount=matchInfoDao.getPlayedMatch(filterdto);
			Map<String, Long> teamWinCountMap = matchInfoDao.getTeamwiseWinCount(filterdto);
			List<String> uniqueTeamNames = matchInfoDao.getUniqueTeamNames(filterdto);
			for(String uniqueName : uniqueTeamNames){
				if(teamWinCountMap.containsKey(uniqueName)){
					TeamInfoDto teamDto = new TeamInfoDto();
					teamDto.setMatchCount(matchcount);
					//Map<String, Long> uniqueTeamWinnerCount = matchInfoDao.getUniqueTeamWinCount(uniqueName,filterdto);
					Long teamPlayedCount=matchInfoDao.getPlayedMatchCount(uniqueName, filterdto);
					teamDto.setPlayedCount(teamPlayedCount);
				
					teamDto.setWinnerCount(teamWinCountMap.get(uniqueName));
					teamDto.setLossCount(teamPlayedCount - teamWinCountMap.get(uniqueName));
					teamDto.setTeamName(uniqueName);
					
					teamDtoList.add(teamDto);
					System.out.println(teamDto);
				}
				
				System.out.println(teamDtoList);
			}
			
			
		}
		else {
			Long matchcount=matchInfoDao.getPlayedMatch(filterdto);
			Map<String, Long> teamWinCountMap = matchInfoDao.getTeamwiseWinCount(filterdto);
			List<String> uniqueTeamNames = matchInfoDao.getUniqueTeamNames(filterdto);
				for(String uniqueName : uniqueTeamNames){
					TeamInfoDto teamDto = new TeamInfoDto();
					teamDto.setMatchCount(matchcount);
					Long teamPlayedCount=matchInfoDao.getPlayedMatchCount(uniqueName, filterdto);
					teamDto.setPlayedCount(teamPlayedCount);
					if(teamWinCountMap.containsKey(uniqueName)){
						teamDto.setWinnerCount(teamWinCountMap.get(uniqueName));
						teamDto.setLossCount(teamPlayedCount - teamWinCountMap.get(uniqueName));
						teamDto.setTeamName(uniqueName);
					}
					teamDtoList.add(teamDto);
				}
			System.out.println(uniqueTeamNames);
		}
		FinalDto finalDto = new FinalDto();
		finalDto.setResult(teamDtoList);
		return finalDto;
	}
	
	

	/*@Override
	public FinalDto getMatchInfo(String filterType, String filterValue, FilterDto filtedto) {
		List<InfEntity> matchList = matchInfoDao.getAllMatches(filterType,filterValue);
		List<MatchInfoDto> matchInfoDtoList = new  ArrayList<>();
		for(InfEntity match : matchList) {
			MatchInfoDto matchInfoDto = new MatchInfoDto();
			Hibernate.initialize(match.getInnings());
		    List<InningEntity> innings = match.getInnings();
		    List<InningInfoDto> inningInfoDtoList = new ArrayList<>();
		    
		    
		    
		     // inning data
		    * 
		    * for(InningEntity inning : innings){
		    	InningInfoDto inningInfoDto = new InningInfoDto();
		    	Hibernate.initialize(inning.getDeliveries());
		    	List<DeliveryEntity> deliveries = inning.getDeliveries();
		    	List<DeliveryInfoDto> deliveryInfoDtoList = new ArrayList<>();
		    	for(DeliveryEntity delivery : deliveries){
		    		DeliveryInfoDto deliveryInfoDto = new DeliveryInfoDto();
		    		BeanUtils.copyProperties(delivery, deliveryInfoDto);
		    		deliveryInfoDtoList.add(deliveryInfoDto);
		    	}
		    	BeanUtils.copyProperties(inning, inningInfoDto);
		    	inningInfoDto.setDeliveries(deliveryInfoDtoList);
		    	inningInfoDtoList.add(inningInfoDto);
		    }  **
		    
		    
		    
		    BeanUtils.copyProperties(match, matchInfoDto);
		    matchInfoDto.setInnings(inningInfoDtoList);
		    
		    matchInfoDtoList.add(matchInfoDto);
		}
		FinalDto result = new FinalDto();
		result.setResult(matchInfoDtoList);
		
		return result;
		
	}*/

}
