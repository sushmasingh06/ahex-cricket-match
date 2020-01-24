package com.ahex.match.service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Hibernate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ahex.match.dao.MatchInfoDAO;
import com.ahex.match.dto.AverageScoreDto;
import com.ahex.match.dto.FilterDto;
import com.ahex.match.dto.FinalDto;
import com.ahex.match.dto.InningInfoDto;
import com.ahex.match.dto.MatchInfoDto;
import com.ahex.match.dto.ScoreFilterDto;
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
import com.fasterxml.jackson.databind.exc.IgnoredPropertyException;
import com.mysql.cj.jdbc.ha.LoadBalancedMySQLConnection;



@Service
@Transactional
public class MatchServiceImpl implements MatchService {

	@Autowired
	MatchInfoDAO matchInfoDao;
	
	public void transferdataToEntity(Meta met) {
		
		Long totalInnngRun=0L;
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
		if(null != info.getNeutral_venue())
			infentity.setNeutral_venue(info.getNeutral_venue());
		
		// outcome inside inf
		Outcome outcome = info.getOutcome();
		//OutcomeEntity outcomeEntity = new OutcomeEntity();
		
		
		if(null != outcome.getWinner())
			infentity.setOut_come_winner(outcome.getWinner());
		if(null != outcome.getBy())
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
		if(null !=info.getOvers())
			infentity.setOvers(info.getOvers());
		if(null != info.getPlayer_of_match())
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
						
						if(null !=deliveryMap.getKey())
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
							
							  totalInnngRun=totalInnngRun+deliveryEntity.getRun_total();
							  inningEntity.setTotal_run(totalInnngRun);
							  System.out.println(totalInnngRun);
						}
						inningEntity.setTotal_run(totalInnngRun);
						  System.out.println(totalInnngRun);
							
						
						
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
				totalInnngRun=0L;
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

	// Average score
	@Override
	public FinalDto getAverageScore(String filterType, ScoreFilterDto scoreFilterDto) {
		FinalDto result = new FinalDto();
		//List<InfEntity> matchList=matchInfoDao.getMatchData();
		//System.out.println(matchList);
	
		//Average Score By inning
		if(filterType!=null && filterType.equalsIgnoreCase("ScoreByInning")){
			//Map<String , Long> matchCountOfVenue=matchInfoDao.getMatchCountOfVenue(scoreFilterDto);
			
		}else if(filterType!=null && filterType.equalsIgnoreCase("ScoreOfPerticularTeam")) {
			AverageScoreDto averageScoreDto=averageCalculation(filterType,scoreFilterDto, null);
			
			result.setResult(averageScoreDto);
		}else if(filterType!=null && filterType.equalsIgnoreCase("ScoreOfPerticularGround")) {
			AverageScoreDto averageScoreDto=averageCalculation(filterType,scoreFilterDto,null);
			
			
			result.setResult(averageScoreDto);
			}else { if(scoreFilterDto!=null) {
				List<AverageScoreDto> listResult= new ArrayList<>();//return
				Map<String , Long> venuAndMatchCountMap=matchInfoDao.getVenuAndMatchCountMap();
				//venue
				for(Map.Entry<String, Long> ground: venuAndMatchCountMap.entrySet()) {
					
					AverageScoreDto averageScoreDto=averageCalculation(filterType,scoreFilterDto,ground.getKey());
					averageScoreDto.setGroundName(ground.getKey());
					/*AverageScoreDto averageScoreDto =new AverageScoreDto();
					averageScoreDto.setGroundName(ground.getKey());
					averageScoreDto.setMatchCount(ground.getValue());
					
					Iterator<InfEntity> iterator = ground.;
					double min = iterator.next();
					
					List<InfEntity> listOfMatch = matchInfoDao.listOfMatchByFilterType(ground.getKey(),null);
					int venueAverage=0;
					long previousMatchMin =0L;
					long previousMatchMax=0L;
					long finalMin=0L;
					long finalMax=0L;
					//match
					for(InfEntity match : listOfMatch) {
							averageScoreDto.setMatch(match.getTeams());
							Hibernate.initialize(match.getInnings());
							int matchAverage=0;
							long previousInningMin = 0L;
							long previousInningMax = 0L;
							long currentmatchMin=0L;
							long currentmatchMax=0L;
							//Inning
							for(InningEntity inning :match.getInnings()) {
								//min Score
								if(!inning.getInningName().contains("Super Over")) {
									long totalRun=inning.getTotal_run();
									if(previousInningMin ==0) {
										previousInningMin=totalRun;
									}
									if(totalRun < previousInningMin) {
										previousInningMin=totalRun;
									}
								}
								
								//max Score
								if(!inning.getInningName().contains("Super Over")) {
									long totalRun=inning.getTotal_run();
									if(previousInningMax ==0) {
										previousInningMax=totalRun;
									}
									if(totalRun > previousInningMax) {
										previousInningMax=totalRun;
									}
								}
								
								matchAverage=(int) (matchAverage+inning.getTotal_run());
								
							}
							
							
							matchAverage=(matchAverage)/(match.getInnings().size());
							
							venueAverage=venueAverage+matchAverage;
							// min score
							currentmatchMin=previousInningMin;
							if(previousMatchMin==0) {
								previousMatchMin=currentmatchMin;
							}
							if(currentmatchMin<previousMatchMin) {
								previousMatchMin=currentmatchMin;
							}
							
							//max score
							currentmatchMax=previousInningMax;
							if(previousMatchMax==0) {
								previousMatchMax=currentmatchMax;
							}
							if(currentmatchMax>previousMatchMax) {
								previousMatchMax=currentmatchMax;
							}
							
					}
					finalMin=previousMatchMin;
					finalMax=previousMatchMax;
					
						venueAverage=(venueAverage)/(listOfMatch.size());
						averageScoreDto.setAverageScore((long) venueAverage);
						averageScoreDto.setMinScore(finalMin);
						averageScoreDto.setMaxScore(finalMax);*/
						listResult.add(averageScoreDto);
						//System.out.println(listResult);
										}
				//FinalDto result = new FinalDto();
				result.setResult(listResult);
			}
		
		}
	
		return result;
	}
	
	
	public AverageScoreDto averageCalculation(String filterType, ScoreFilterDto scoreFilterDto, String filterValue) {

		AverageScoreDto averageScoreDto =new AverageScoreDto();
		long matchAverage=0;
		List<InfEntity> listOfMatch = new ArrayList<>();
		if(filterType != null ) {
			if(filterType.equalsIgnoreCase("ScoreOfPerticularGround")) {
				listOfMatch = matchInfoDao.listOfMatchByFilterType(scoreFilterDto.getGround(),filterType);
			}else if(filterType.equalsIgnoreCase("ScoreOfPerticularTeam")) {
				listOfMatch = matchInfoDao.listOfMatchByFilterType(scoreFilterDto.getTeam(),filterType);
			}else if(filterType.equalsIgnoreCase("ScoreByInning")) {
				
			}/*else {
				listOfMatch = matchInfoDao.listOfMatchByFilterType(filterValue,null);
			}*/
		}else {
			listOfMatch = matchInfoDao.listOfMatchByFilterType(filterValue,null);
		}
		
		
		//List<InfEntity> listOfMatch = matchInfoDao.listOfMatchByVenue(scoreFilterDto.getGround());
		//if(!listOfMatch.isEmpty() && listOfMatch.size()!=0) {
			averageScoreDto.setGroundName(scoreFilterDto.getGround());
			averageScoreDto.setMatchCount((long) listOfMatch.size());
			int venueAverage=0;
			long previousMatchMin =0L;
			long previousMatchMax=0L;
			long finalMin=0L;
			long finalMax=0L;
			//match
			for(InfEntity match : listOfMatch) {
					averageScoreDto.setMatch(match.getTeams());
					Hibernate.initialize(match.getInnings());
					//int matchAverage=0;
					long previousInningMin = 0L;
					long previousInningMax = 0L;
					long currentmatchMin=0L;
					long currentmatchMax=0L;
					//Inning
					for(InningEntity inning :match.getInnings()) {
						//min Score
						if(!inning.getInningName().contains("Super Over")) {
							long totalRun=inning.getTotal_run();
							if(previousInningMin ==0) {
								previousInningMin=totalRun;
							}
							if(totalRun < previousInningMin) {
								previousInningMin=totalRun;
							}
						}
						
						//max Score
						if(!inning.getInningName().contains("Super Over")) {
							long totalRun=inning.getTotal_run();
							if(previousInningMax ==0) {
								previousInningMax=totalRun;
							}
							if(totalRun > previousInningMax) {
								previousInningMax=totalRun;
							}
						}
						
						matchAverage=(int) (matchAverage+inning.getTotal_run());
						
					}
					
					
					matchAverage=(matchAverage)/(match.getInnings().size());
					
					venueAverage=(int) (venueAverage+matchAverage);
					// min score
					currentmatchMin=previousInningMin;
					if(previousMatchMin==0) {
						previousMatchMin=currentmatchMin;
					}
					if(currentmatchMin<previousMatchMin) {
						previousMatchMin=currentmatchMin;
					}
					
					//max score
					currentmatchMax=previousInningMax;
					if(previousMatchMax==0) {
						previousMatchMax=currentmatchMax;
					}
					if(currentmatchMax>previousMatchMax) {
						previousMatchMax=currentmatchMax;
					}
					
			}
			finalMin=previousMatchMin;
			finalMax=previousMatchMax;
			
				venueAverage=(venueAverage)/(listOfMatch.size());
				averageScoreDto.setAverageScore((long) venueAverage);
				averageScoreDto.setMinScore(finalMin);
				averageScoreDto.setMaxScore(finalMax);
				//listResult.add(averageScoreDto);
				System.out.println(finalMax);

		return averageScoreDto;
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
