package com.ahex.match.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ahex.match.dto.FilterDto;
import com.ahex.match.dto.ScoreFilterDto;
import com.ahex.match.entities.InfEntity;



@Repository
public class MatchInfoADAOImpl implements MatchInfoDAO{

	@Autowired
	private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    

	
	public void saveMatchInfo(InfEntity mainEntity) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		//MetaEntity mainEntity1 = transferdataToEntity(mainEntity);
		session.save(mainEntity);
		tx.commit();
		session.close();
	}



	@SuppressWarnings("unchecked")
	@Override
	public List<String> getTeamName(String team) {
		 Session session = sessionFactory.getCurrentSession();
		 List<String> teamNames = new ArrayList<String>();
		 List<Object> result = null;
		 /* CriteriaBuilder cb = session.getCriteriaBuilder();
	      CriteriaQuery<InningEntity> cq = cb.createQuery(InningEntity.class);
	      Root<InningEntity> root = cq.from(InningEntity.class);
	      cq.multiselect(root);
	      Query query = session.createQuery(cq);*/
		//InningEntity inningEntity=null;
		StringBuilder builder = new StringBuilder();
		builder.append("select DISTINCT(i.team) from InningEntity i  ");
		result = session.createQuery(builder.toString()).getResultList();
		for(Object obj : result) {
			teamNames.add(obj.toString());
		}
		return   teamNames;
		
	}




     /*   **********************************************************************************  */
	
	@Override
	public List<String> getUniqueTeamNames(FilterDto filterdto) {
		 Session session = sessionFactory.getCurrentSession();
		 List<String> teamNames = new ArrayList<String>(); 
		StringBuilder builder = new StringBuilder();
		builder.append("select distinct(i.team) from InningEntity i");
		
		teamNames = (List<String>)session.createQuery(builder.toString()).getResultList();
		
		return teamNames;
	}


	@Override
	public Long getPlayedMatch(FilterDto filterdto) {
		 Session session = sessionFactory.getCurrentSession();
		 Long playedTeamCount;
		 StringBuilder builder = new StringBuilder();
		builder.append("select count(i) from InfEntity i ");
		boolean isFoundColumn=false;
		
		if(filterdto != null) {
			if(filterdto.getCity()!= null || filterdto.getDate()!=null || filterdto.getGender()!=null || filterdto.getMatch_type() !=null || 
					 filterdto.getOvers() !=null ||  filterdto.getUmpires() !=null ||filterdto.getVenue() !=null || 
					 filterdto.getCompetition() != null || filterdto.getNatural_values() !=null || filterdto.getTeams()!=null) {
				
				builder.append(" where ");
				if(filterdto.getCity() != null) {
					if(!isFoundColumn) {
						builder.append(" i.city like :city ");
					}else {
						builder.append(" and i.city like :city ");
					}
					isFoundColumn = true;
				}
				if(filterdto.getDate() != null) {
					if(!isFoundColumn) {
						builder.append(" i.dates like :date ");
					}else {
						builder.append(" and i.dates like :date ");
					}
					isFoundColumn = true;
				}
				if(filterdto.getGender() != null) { 
					if(!isFoundColumn) {
						builder.append(" i.gender like :gender ");
					}
					else {
						builder.append(" and i.gender like :gender ");
					}
					isFoundColumn=true;
				}
				if(filterdto.getMatch_type() !=null) {
					if(!isFoundColumn) {
						builder.append(" i.match_type like :match_type ");
					}
					else {
						builder.append(" and i.match_type like :match_type");
					}
					isFoundColumn=true;
				}
				if(filterdto.getOvers() != null) {
					if(!isFoundColumn) {
						builder.append(" i.overs like :over ");
					}
					else {
						builder.append(" and i.overs like :over ");
					}
					isFoundColumn=true;
				}
				if(filterdto.getUmpires() !=null) {
					if(!isFoundColumn) {
						builder.append(" i.umpires like :umpires");
					}
					else {
						builder.append(" and i.umpires like :umpires");
					}
					isFoundColumn=true;
				}
				if(filterdto.getVenue() !=null) {
					if(!isFoundColumn) {
						builder.append(" i.venue like :venue");
					}
					else {
						builder.append(" and i.venue like :venue");
					}
					isFoundColumn=true;
				}
				if(filterdto.getCompetition() !=null) {
					if(!isFoundColumn) {
						builder.append(" i.competition like :competition");
					}
					else {
						builder.append(" i.competition like :competition");
					}
					isFoundColumn=true;
				}
				if(filterdto.getNatural_values() !=null) {
					if(!isFoundColumn) {
						builder.append(" i.natural_value like :natural_value ");
					}
					else {
						builder.append(" i.natural_value like :natural_value ");
					}
					isFoundColumn=true;
				}
				if(filterdto.getTeams() !=null) {
					if(!isFoundColumn) {
						builder.append(" i.teams like :team ");
					}
					else {
						builder.append(" and i.team like :team ");
					}
					isFoundColumn=true;
				}
			}
		}
		
		//set parameter
		Query query = session.createQuery(builder.toString());
		if(filterdto !=null) {
			if(filterdto.getCity()!= null || filterdto.getDate()!=null || filterdto.getGender()!=null || filterdto.getMatch_type() !=null || 
					 filterdto.getOvers() !=null ||  filterdto.getUmpires() !=null ||filterdto.getVenue() !=null || 
					 filterdto.getCompetition() != null || filterdto.getNatural_values() !=null || filterdto.getTeams()!=null) {
				
				
				if(filterdto.getCity() != null) {
					if(!isFoundColumn) {
						query.setParameter("city", "%"+filterdto.getCity()+"%");
					}else {
						query.setParameter("city", "%"+filterdto.getCity()+"%");
					}
					isFoundColumn = true;
				}
				if(filterdto.getDate() != null) {
					if(!isFoundColumn) {
						query.setParameter("date", "%"+filterdto.getDate()+"%");
					}else {
						query.setParameter("date", "%"+filterdto.getDate()+"%");
					}
					isFoundColumn = true;
				}
				if(filterdto.getGender() != null) { 
					if(!isFoundColumn) {
						query.setParameter("gender", "%"+filterdto.getGender()+"%");
					}
					else {
						query.setParameter("gender", "%"+filterdto.getGender()+"%");
					}
					isFoundColumn=true;
				}
				if(filterdto.getMatch_type() !=null) {
					if(!isFoundColumn) {
						query.setParameter("match_type", "%"+filterdto.getMatch_type()+"%");
					}
					else {
						query.setParameter("match_type", "%"+filterdto.getMatch_type()+"%");
					}
					isFoundColumn=true;
				}
				if(filterdto.getOvers() != null) {
					if(!isFoundColumn) {
						query.setParameter("overs", "%"+filterdto.getOvers()+"%");
					}
					else {
						query.setParameter("overs", "%"+filterdto.getOvers()+"%");
					}
					isFoundColumn=true;
				}
				if(filterdto.getUmpires() !=null) {
					if(!isFoundColumn) {
						query.setParameter("umpires", "%"+filterdto.getUmpires()+"%");
					}
					else {
						query.setParameter("umpires", "%"+filterdto.getUmpires()+"%");
					}
					isFoundColumn=true;
				}
				if(filterdto.getVenue() !=null) {
					if(!isFoundColumn) {
						query.setParameter("venue", "%"+filterdto.getVenue()+"%");
					}
					else {
						query.setParameter("venue", "%"+filterdto.getVenue()+"%");
					}
					isFoundColumn=true;
				}
				if(filterdto.getCompetition() !=null) {
					if(!isFoundColumn) {
						query.setParameter("competition", "%"+filterdto.getCompetition()+"%");
					}
					else {
						query.setParameter("competition", "%"+filterdto.getCompetition()+"%");
					}
					isFoundColumn=true;
				}
				if(filterdto.getNatural_values() !=null) {
					if(!isFoundColumn) {
						query.setParameter("natural_value", "%"+filterdto.getNatural_values()+"%");
					}
					else {
						query.setParameter("natural_value", "%"+filterdto.getNatural_values()+"%");
					}
					isFoundColumn=true;
				}
				if(filterdto.getTeams() !=null) {
					if(!isFoundColumn) {
						query.setParameter("team", "%"+filterdto.getTeams()+"%");
					}
					else {
						query.setParameter("team", "%"+filterdto.getTeams()+"%");
					}
					isFoundColumn=true;
				}
			}
		}

		playedTeamCount = (Long) query.getSingleResult();
		
		return playedTeamCount;
		
	}


	@Override
	public Long getPlayedMatchCount(String teamNames,FilterDto filterdto) {
		Session session = sessionFactory.getCurrentSession();
		 Long playedMatchCount;
		 StringBuilder builder = new StringBuilder();
		builder.append("select count(i) from InfEntity i where i.teams Like :teamNames and ");
		
		boolean isFoundColumn =false;
		if(filterdto != null) {
			if(filterdto.getCity()!= null || filterdto.getDate()!=null || filterdto.getGender()!=null || filterdto.getMatch_type() !=null || 
					 filterdto.getOvers() !=null ||  filterdto.getUmpires() !=null ||filterdto.getVenue() !=null || 
					 filterdto.getCompetition() != null || filterdto.getNatural_values() !=null ) {
				
				//builder.append(" where ");
				if(filterdto.getCity() != null) {
					if(!isFoundColumn) {
						builder.append(" i.city like :city ");
					}else {
						builder.append(" and i.city like :city ");
					}
					isFoundColumn = true;
				}
				if(filterdto.getDate() != null) {
					if(!isFoundColumn) {
						builder.append(" i.dates like :date ");
					}else {
						builder.append(" and i.dates like :date ");
					}
					isFoundColumn = true;
				}
				if(filterdto.getGender() != null) { 
					if(!isFoundColumn) {
						builder.append(" i.gender like :gender ");
					}
					else {
						builder.append(" and i.gender like :gender ");
					}
					isFoundColumn=true;
				}
				if(filterdto.getMatch_type() !=null) {
					if(!isFoundColumn) {
						builder.append(" i.match_type like :match_type ");
					}
					else {
						builder.append(" and i.match_type like :match_type");
					}
					isFoundColumn=true;
				}
				if(filterdto.getOvers() != null) {
					if(!isFoundColumn) {
						builder.append(" i.overs like :over ");
					}
					else {
						builder.append(" and i.overs like :over ");
					}
					isFoundColumn=true;
				}
				if(filterdto.getUmpires() !=null) {
					if(!isFoundColumn) {
						builder.append(" i.umpires like :umpires");
					}
					else {
						builder.append(" and i.umpires like :umpires");
					}
					isFoundColumn=true;
				}
				if(filterdto.getVenue() !=null) {
					if(!isFoundColumn) {
						builder.append(" i.venue like :venue");
					}
					else {
						builder.append(" and i.venue like :venue");
					}
					isFoundColumn=true;
				}
				if(filterdto.getCompetition() !=null) {
					if(!isFoundColumn) {
						builder.append(" i.competition like :competition");
					}
					else {
						builder.append(" i.competition like :competition");
					}
					isFoundColumn=true;
				}
				if(filterdto.getNatural_values() !=null) {
					if(!isFoundColumn) {
						builder.append(" i.natural_value like :natural_value ");
					}
					else {
						builder.append(" i.natural_value like :natural_value ");
					}
					isFoundColumn=true;
				}
				if(filterdto.getTeams() !=null) {
					if(!isFoundColumn) {
						builder.append(" i.teams like :team ");
					}
					else {
						builder.append(" and i.team like :team ");
					}
					isFoundColumn=true;
				}
			}
		}
		
		//set parameter
		Query query = session.createQuery(builder.toString());
		query.setParameter("teamNames", "%"+teamNames+"%");
		
		if(filterdto !=null) {
			if(filterdto.getCity()!= null || filterdto.getDate()!=null || filterdto.getGender()!=null || filterdto.getMatch_type() !=null || 
					 filterdto.getOvers() !=null ||  filterdto.getUmpires() !=null ||filterdto.getVenue() !=null || 
					 filterdto.getCompetition() != null || filterdto.getNatural_values() !=null ) {
				
				
				if(filterdto.getCity() != null) {
					if(!isFoundColumn) {
						query.setParameter("city", "%"+filterdto.getCity()+"%");
					}else {
						query.setParameter("city", "%"+filterdto.getCity()+"%");
					}
					isFoundColumn = true;
				}
				if(filterdto.getDate() != null) {
					if(!isFoundColumn) {
						query.setParameter("date", "%"+filterdto.getDate()+"%");
					}else {
						query.setParameter("date", "%"+filterdto.getDate()+"%");
					}
					isFoundColumn = true;
				}
				if(filterdto.getGender() != null) { 
					if(!isFoundColumn) {
						query.setParameter("gender", "%"+filterdto.getGender()+"%");
					}
					else {
						query.setParameter("gender", "%"+filterdto.getGender()+"%");
					}
					isFoundColumn=true;
				}
				if(filterdto.getMatch_type() !=null) {
					if(!isFoundColumn) {
						query.setParameter("match_type", "%"+filterdto.getMatch_type()+"%");
					}
					else {
						query.setParameter("match_type", "%"+filterdto.getMatch_type()+"%");
					}
					isFoundColumn=true;
				}
				if(filterdto.getOvers() != null) {
					if(!isFoundColumn) {
						query.setParameter("overs", "%"+filterdto.getOvers()+"%");
					}
					else {
						query.setParameter("overs", "%"+filterdto.getOvers()+"%");
					}
					isFoundColumn=true;
				}
				if(filterdto.getUmpires() !=null) {
					if(!isFoundColumn) {
						query.setParameter("umpires", "%"+filterdto.getUmpires()+"%");
					}
					else {
						query.setParameter("umpires", "%"+filterdto.getUmpires()+"%");
					}
					isFoundColumn=true;
				}
				if(filterdto.getVenue() !=null) {
					if(!isFoundColumn) {
						query.setParameter("venue", "%"+filterdto.getVenue()+"%");
					}
					else {
						query.setParameter("venue", "%"+filterdto.getVenue()+"%");
					}
					isFoundColumn=true;
				}
				if(filterdto.getCompetition() !=null) {
					if(!isFoundColumn) {
						query.setParameter("competition", "%"+filterdto.getCompetition()+"%");
					}
					else {
						query.setParameter("competition", "%"+filterdto.getCompetition()+"%");
					}
					isFoundColumn=true;
				}
				if(filterdto.getNatural_values() !=null) {
					if(!isFoundColumn) {
						query.setParameter("natural_value", "%"+filterdto.getNatural_values()+"%");
					}
					else {
						query.setParameter("natural_value", "%"+filterdto.getNatural_values()+"%");
					}
					isFoundColumn=true;
				}
				if(filterdto.getTeams() !=null) {
					if(!isFoundColumn) {
						query.setParameter("team", "%"+filterdto.getTeams()+"%");
					}
					else {
						query.setParameter("team", "%"+filterdto.getTeams()+"%");
					}
					isFoundColumn=true;
				}
			}
		}
		
		playedMatchCount = (Long) query.getSingleResult();
		
		return playedMatchCount;
	}


	@Override
	public Map<String, Long> getTeamwiseWinCount(FilterDto filterdto) {
		Session session = sessionFactory.getCurrentSession();
		Map<String, Long> teamWinCountMap = new HashMap<String, Long>();
		StringBuilder builder = new StringBuilder();
		List<Object[]> result = null;
		builder.append("select i.out_come_winner, count(i) from InfEntity i ");
		
		
		boolean isFoundColumn =false;
		if(filterdto != null) {
			if(filterdto.getCity()!= null || filterdto.getDate()!=null || filterdto.getGender()!=null || filterdto.getMatch_type() !=null || 
					 filterdto.getOvers() !=null ||  filterdto.getUmpires() !=null ||filterdto.getVenue() !=null || 
					 filterdto.getCompetition() != null || filterdto.getNatural_values() !=null || filterdto.getTeams()!=null) {
				
				builder.append(" where ");
				if(filterdto.getCity() != null) {
					if(!isFoundColumn) {
						builder.append(" i.city like :city ");
					}else {
						builder.append(" and i.city like :city ");
					}
					isFoundColumn = true;
				}
				if(filterdto.getDate() != null) {
					if(!isFoundColumn) {
						builder.append(" i.dates like :date ");
					}else {
						builder.append(" and i.dates like :date ");
					}
					isFoundColumn = true;
				}
				if(filterdto.getGender() != null) { 
					if(!isFoundColumn) {
						builder.append(" i.gender like :gender ");
					}
					else {
						builder.append(" and i.gender like :gender ");
					}
					isFoundColumn=true;
				}
				if(filterdto.getMatch_type() !=null) {
					if(!isFoundColumn) {
						builder.append(" i.match_type like :match_type ");
					}
					else {
						builder.append(" and i.match_type like :match_type");
					}
					isFoundColumn=true;
				}
				if(filterdto.getOvers() != null) {
					if(!isFoundColumn) {
						builder.append(" i.overs like :over ");
					}
					else {
						builder.append(" and i.overs like :over ");
					}
					isFoundColumn=true;
				}
				if(filterdto.getUmpires() !=null) {
					if(!isFoundColumn) {
						builder.append(" i.umpires like :umpires");
					}
					else {
						builder.append(" and i.umpires like :umpires");
					}
					isFoundColumn=true;
				}
				if(filterdto.getVenue() !=null) {
					if(!isFoundColumn) {
						builder.append(" i.venue like :venue");
					}
					else {
						builder.append(" and i.venue like :venue");
					}
					isFoundColumn=true;
				}
				if(filterdto.getCompetition() !=null) {
					if(!isFoundColumn) {
						builder.append(" i.competition like :competition");
					}
					else {
						builder.append(" i.competition like :competition");
					}
					isFoundColumn=true;
				}
				if(filterdto.getNatural_values() !=null) {
					if(!isFoundColumn) {
						builder.append(" i.natural_value like :natural_value ");
					}
					else {
						builder.append(" i.natural_value like :natural_value ");
					}
					isFoundColumn=true;
				}
				if(filterdto.getTeams() !=null) {
					if(!isFoundColumn) {
						builder.append(" i.teams like :team ");
					}
					else {
						builder.append(" and i.team like :team ");
					}
					isFoundColumn=true;
				}
			}
		}
		builder.append(" group by i.out_come_winner");
		//set parameter
		Query query = session.createQuery(builder.toString());
		if(filterdto !=null) {
			if(filterdto.getCity()!= null || filterdto.getDate()!=null || filterdto.getGender()!=null || filterdto.getMatch_type() !=null || 
					 filterdto.getOvers() !=null ||  filterdto.getUmpires() !=null ||filterdto.getVenue() !=null || 
					 filterdto.getCompetition() != null || filterdto.getNatural_values() !=null || filterdto.getTeams()!=null) {
				
				
				if(filterdto.getCity() != null) {
					if(!isFoundColumn) {
						query.setParameter("city", "%"+filterdto.getCity()+"%");
					}else {
						query.setParameter("city", "%"+filterdto.getCity()+"%");
					}
					isFoundColumn = true;
				}
				if(filterdto.getDate() != null) {
					if(!isFoundColumn) {
						query.setParameter("date", "%"+filterdto.getDate()+"%");
					}else {
						query.setParameter("date", "%"+filterdto.getDate()+"%");
					}
					isFoundColumn = true;
				}
				if(filterdto.getGender() != null) { 
					if(!isFoundColumn) {
						query.setParameter("gender", "%"+filterdto.getGender()+"%");
					}
					else {
						query.setParameter("gender", "%"+filterdto.getGender()+"%");
					}
					isFoundColumn=true;
				}
				if(filterdto.getMatch_type() !=null) {
					if(!isFoundColumn) {
						query.setParameter("match_type", "%"+filterdto.getMatch_type()+"%");
					}
					else {
						query.setParameter("match_type", "%"+filterdto.getMatch_type()+"%");
					}
					isFoundColumn=true;
				}
				if(filterdto.getOvers() != null) {
					if(!isFoundColumn) {
						query.setParameter("overs", "%"+filterdto.getOvers()+"%");
					}
					else {
						query.setParameter("overs", "%"+filterdto.getOvers()+"%");
					}
					isFoundColumn=true;
				}
				if(filterdto.getUmpires() !=null) {
					if(!isFoundColumn) {
						query.setParameter("umpires", "%"+filterdto.getUmpires()+"%");
					}
					else {
						query.setParameter("umpires", "%"+filterdto.getUmpires()+"%");
					}
					isFoundColumn=true;
				}
				if(filterdto.getVenue() !=null) {
					if(!isFoundColumn) {
						query.setParameter("venue", "%"+filterdto.getVenue()+"%");
					}
					else {
						query.setParameter("venue", "%"+filterdto.getVenue()+"%");
					}
					isFoundColumn=true;
				}
				if(filterdto.getCompetition() !=null) {
					if(!isFoundColumn) {
						query.setParameter("competition", "%"+filterdto.getCompetition()+"%");
					}
					else {
						query.setParameter("competition", "%"+filterdto.getCompetition()+"%");
					}
					isFoundColumn=true;
				}
				if(filterdto.getNatural_values() !=null) {
					if(!isFoundColumn) {
						query.setParameter("natural_value", "%"+filterdto.getNatural_values()+"%");
					}
					else {
						query.setParameter("natural_value", "%"+filterdto.getNatural_values()+"%");
					}
					isFoundColumn=true;
				}
				if(filterdto.getTeams() !=null) {
					if(!isFoundColumn) {
						query.setParameter("team", "%"+filterdto.getTeams()+"%");
					}
					else {
						query.setParameter("team", "%"+filterdto.getTeams()+"%");
					}
					isFoundColumn=true;
				}
			}
		}
		
		result = (List<Object[]>)query.getResultList();
		for(Object[] object : result){
			teamWinCountMap.put(object[0].toString(), Long.valueOf(object[1].toString()));
		}
		return teamWinCountMap;
	}
	
	

	/*
	//for single request param
	@Override
	public List<InfEntity> getAllMatches(String filterType, String filterValue) {
	
		Session session = sessionFactory.getCurrentSession();
		List<InfEntity> result = new ArrayList<>();
		StringBuilder builder = new StringBuilder();
		builder.append("select i from InfEntity i ");
		if(filterType != null && filterValue != null){
			if(filterType.equalsIgnoreCase("venue")){
				builder.append(" where i.venue like :venue");
			}else if(filterType.equalsIgnoreCase("city")){
				builder.append(" where i.city like :city");
			}else if (filterType.equalsIgnoreCase("date")){
				builder.append(" where i.dates like :date");
			}else if (filterType.equalsIgnoreCase("competition")){
				builder.append(" where i.competition like :competition");
			}else if (filterType.equalsIgnoreCase("gender")){
				builder.append(" where i.gender like :gender");
			}else if (filterType.equalsIgnoreCase("match_type")){
				builder.append(" where i.match_type like :match_type");
			}else if (filterType.equalsIgnoreCase("overs")){
				builder.append(" where i.overs = :overs");
			}else if (filterType.equalsIgnoreCase("neutral_venue")){
				builder.append(" where i.neutral_venue like :neutral_venue");
			}else if (filterType.equalsIgnoreCase("teams")){
				builder.append(" where i.teams like :teams");
			}else if (filterType.equalsIgnoreCase("umpires")){
				builder.append(" where i.umpires like :umpires");
			}
			
		}
		Query query = session.createQuery(builder.toString());
		if(filterType != null && filterValue != null){
			if(filterType.equalsIgnoreCase("venue")){
				query.setParameter("venue", "%"+filterValue+"%");
			}else if(filterType.equalsIgnoreCase("city")){
				query.setParameter("city", "%"+filterValue+"%");
			}else if (filterType.equalsIgnoreCase("date")){
				query.setParameter("date", "%"+filterValue+"%");
			}else if (filterType.equalsIgnoreCase("competition")){
				query.setParameter("competition", "%"+filterValue+"%");
			}else if (filterType.equalsIgnoreCase("gender")){
				query.setParameter("gender", "%"+filterValue+"%");
			}else if (filterType.equalsIgnoreCase("match_type")){
				query.setParameter("match_type", "%"+filterValue+"%");
			}else if (filterType.equalsIgnoreCase("overs")){
				query.setParameter("overs", filterValue);
			}else if (filterType.equalsIgnoreCase("neutral_venue")){
				query.setParameter("neutral_venue", "%"+filterValue+"%");
			}else if (filterType.equalsIgnoreCase("teams")){
				query.setParameter("teams", "%"+filterValue+"%");
			}else if (filterType.equalsIgnoreCase("umpires")){
				query.setParameter("umpires", "%"+filterValue+"%");
			}
		}
		result = (List<InfEntity>) query.getResultList();
	
		return result;
	}
*/

	//get Match data by multiple parameter
	@Override
	public List<InfEntity> getAllMatchesByParameter(FilterDto filterdto) {
		
		Session session = sessionFactory.getCurrentSession();
		List<InfEntity> result = new ArrayList<>();
		StringBuilder builder = new StringBuilder();
		boolean isFoundColumn = false;
		builder.append("select i from InfEntity i ");
		if(filterdto != null) {
			if(filterdto.getCity()!= null || filterdto.getDate()!=null || filterdto.getGender()!=null || filterdto.getMatch_type() !=null || 
					 filterdto.getOvers() !=null ||  filterdto.getUmpires() !=null ||filterdto.getVenue() !=null || 
					 filterdto.getCompetition() != null || filterdto.getNatural_values() !=null || filterdto.getTeams()!=null) {
				
				builder.append(" where ");
				if(filterdto.getCity() != null) {
					if(!isFoundColumn) {
						builder.append(" i.city like :city ");
					}else {
						builder.append(" and i.city like :city ");
					}
					isFoundColumn = true;
				}
				if(filterdto.getDate() != null) {
					if(!isFoundColumn) {
						builder.append(" i.dates like :date ");
					}else {
						builder.append(" and i.dates like :date ");
					}
					isFoundColumn = true;
				}
				if(filterdto.getGender() != null) { 
					if(!isFoundColumn) {
						builder.append(" i.gender like :gender ");
					}
					else {
						builder.append(" and i.gender like :gender ");
					}
					isFoundColumn=true;
				}
				if(filterdto.getMatch_type() !=null) {
					if(!isFoundColumn) {
						builder.append(" i.match_type like :match_type ");
					}
					else {
						builder.append(" and i.match_type like :match_type");
					}
					isFoundColumn=true;
				}
				if(filterdto.getOvers() != null) {
					if(!isFoundColumn) {
						builder.append(" i.overs like :over ");
					}
					else {
						builder.append(" and i.overs like :over ");
					}
					isFoundColumn=true;
				}
				if(filterdto.getUmpires() !=null) {
					if(!isFoundColumn) {
						builder.append(" i.umpires like :umpires");
					}
					else {
						builder.append(" and i.umpires like :umpires");
					}
					isFoundColumn=true;
				}
				if(filterdto.getVenue() !=null) {
					if(!isFoundColumn) {
						builder.append(" i.venue like :venue");
					}
					else {
						builder.append(" and i.venue like :venue");
					}
					isFoundColumn=true;
				}
				if(filterdto.getCompetition() !=null) {
					if(!isFoundColumn) {
						builder.append(" i.competition like :competition");
					}
					else {
						builder.append(" i.competition like :competition");
					}
					isFoundColumn=true;
				}
				if(filterdto.getNatural_values() !=null) {
					if(!isFoundColumn) {
						builder.append(" i.natural_value like :natural_value ");
					}
					else {
						builder.append(" i.natural_value like :natural_value ");
					}
					isFoundColumn=true;
				}
				if(filterdto.getTeams() !=null) {
					if(!isFoundColumn) {
						builder.append(" i.teams like :team ");
					}
					else {
						builder.append(" and i.team like :team ");
					}
					isFoundColumn=true;
				}
			}
		}
		
		//set parameter
		Query query = session.createQuery(builder.toString());
		if(filterdto !=null) {
			if(filterdto.getCity()!= null || filterdto.getDate()!=null || filterdto.getGender()!=null || filterdto.getMatch_type() !=null || 
					 filterdto.getOvers() !=null ||  filterdto.getUmpires() !=null ||filterdto.getVenue() !=null || 
					 filterdto.getCompetition() != null || filterdto.getNatural_values() !=null || filterdto.getTeams()!=null) {
				
				
				if(filterdto.getCity() != null) {
					if(!isFoundColumn) {
						query.setParameter("city", "%"+filterdto.getCity()+"%");
					}else {
						query.setParameter("city", "%"+filterdto.getCity()+"%");
					}
					isFoundColumn = true;
				}
				if(filterdto.getDate() != null) {
					if(!isFoundColumn) {
						query.setParameter("date", "%"+filterdto.getDate()+"%");
					}else {
						query.setParameter("date", "%"+filterdto.getDate()+"%");
					}
					isFoundColumn = true;
				}
				if(filterdto.getGender() != null) { 
					if(!isFoundColumn) {
						query.setParameter("gender", "%"+filterdto.getGender()+"%");
					}
					else {
						query.setParameter("gender", "%"+filterdto.getGender()+"%");
					}
					isFoundColumn=true;
				}
				if(filterdto.getMatch_type() !=null) {
					if(!isFoundColumn) {
						query.setParameter("match_type", "%"+filterdto.getMatch_type()+"%");
					}
					else {
						query.setParameter("match_type", "%"+filterdto.getMatch_type()+"%");
					}
					isFoundColumn=true;
				}
				if(filterdto.getOvers() != null) {
					if(!isFoundColumn) {
						query.setParameter("overs", "%"+filterdto.getOvers()+"%");
					}
					else {
						query.setParameter("overs", "%"+filterdto.getOvers()+"%");
					}
					isFoundColumn=true;
				}
				if(filterdto.getUmpires() !=null) {
					if(!isFoundColumn) {
						query.setParameter("umpires", "%"+filterdto.getUmpires()+"%");
					}
					else {
						query.setParameter("umpires", "%"+filterdto.getUmpires()+"%");
					}
					isFoundColumn=true;
				}
				if(filterdto.getVenue() !=null) {
					if(!isFoundColumn) {
						query.setParameter("venue", "%"+filterdto.getVenue()+"%");
					}
					else {
						query.setParameter("venue", "%"+filterdto.getVenue()+"%");
					}
					isFoundColumn=true;
				}
				if(filterdto.getCompetition() !=null) {
					if(!isFoundColumn) {
						query.setParameter("competition", "%"+filterdto.getCompetition()+"%");
					}
					else {
						query.setParameter("competition", "%"+filterdto.getCompetition()+"%");
					}
					isFoundColumn=true;
				}
				if(filterdto.getNatural_values() !=null) {
					if(!isFoundColumn) {
						query.setParameter("natural_value", "%"+filterdto.getNatural_values()+"%");
					}
					else {
						query.setParameter("natural_value", "%"+filterdto.getNatural_values()+"%");
					}
					isFoundColumn=true;
				}
				if(filterdto.getTeams() !=null) {
					if(!isFoundColumn) {
						query.setParameter("team", "%"+filterdto.getTeams()+"%");
					}
					else {
						query.setParameter("team", "%"+filterdto.getTeams()+"%");
					}
					isFoundColumn=true;
				}
			}
		}
		result = (List<InfEntity>) query.getResultList();
		return result;
	}


	@Override
	public List<InfEntity> getMatchData() {
			 Session session = sessionFactory.openSession(); 
			 CriteriaBuilder builder = session.getCriteriaBuilder();
			 CriteriaQuery<InfEntity> criteria = builder.createQuery(InfEntity.class);
			 criteria.from(InfEntity.class);
			 List<InfEntity> entityList = session.createQuery(criteria).getResultList();
		
		/*Session session = sessionFactory.getCurrentSession();
		 List<String> matchData = new ArrayList<String>(); 
		StringBuilder builder = new StringBuilder();
		builder.append("select distinct(i.team) from InningEntity i");
		
		matchData = (List<String>)session.createQuery(builder.toString()).getResultList();
		
		return matchData;*/
		return entityList;
	}



	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Long> getVenuAndMatchCountMap() {
		Session session = sessionFactory.getCurrentSession();
		Map<String, Long> averageScore = new HashMap<String, Long>();
		List<Object[]> result = null;
		StringBuilder builder = new StringBuilder();
		
		builder.append("select i.venue, count(i)  from InfEntity i  ");
		/*builder.append(" where ");
		if(scoreFilterDto !=null) {
			 if(scoreFilterDto.getTeam()!=null && scoreFilterDto.getGround()!=null && scoreFilterDto.getCity()!=null) {
				if(scoreFilterDto.getTeam()!=null)
					builder.append(" i.team like : team ");
				if(scoreFilterDto.getGround()!=null)
					builder.append(" i.venue like : venue ");
				if(scoreFilterDto.getCity() !=null)
					builder.append(" i.city like : city ");
			 }
		}*/
		builder.append(" group by i.venue ");
		Query query = session.createQuery(builder.toString());
		/*if(scoreFilterDto !=null) {
			 if(scoreFilterDto.getTeam()!=null && scoreFilterDto.getGround()!=null && scoreFilterDto.getCity()!=null) {
				 if(scoreFilterDto.getTeam()!=null)
					 query.setParameter("team", "%"+scoreFilterDto.getTeam()+"%");
				 if(scoreFilterDto.getGround()!=null)
					 query.setParameter("venue", "%"+scoreFilterDto.getGround()+"%");
				 if(scoreFilterDto.getCity()!=null)
					 query.setParameter("city", "%"+scoreFilterDto.getCity()+"%");
			 }
		}*/
		result = (List<Object[]>)query.getResultList();
		for(Object[] object : result){
			averageScore.put(object[0].toString(), Long.valueOf(object[1].toString()));
	}
		return averageScore;
	}



	@Override
	public List<InfEntity> listOfMatchByFilterType(String filtervalue, String filterType ) {
		Session session = sessionFactory.getCurrentSession();
		 List<InfEntity> matchList = new ArrayList<InfEntity>(); 
		StringBuilder builder = new StringBuilder();
		builder.append("select i from InfEntity i ");
		if(filterType != null ) {
			if(filterType.equals("ScoreOfPerticularGround") ) {
				builder.append(" where i.venue = :venue ");
			}else if(filterType.equals("ScoreOfPerticularTeam") /*|| filterType == null*/) {
				builder.append(" where i.teams like :team ");
			}
		}else {
				builder.append(" where i.venue = :venue ");
		}
		
		Query query=session.createQuery(builder.toString());
		if(filterType != null ) {
			if(filterType.equals("ScoreOfPerticularGround")) {
				query.setParameter("venue", filtervalue);
			}else if(filterType.equals("ScoreOfPerticularTeam")) {
				query.setParameter("team", "%"+filtervalue+"%");
			}
		}else {
			query.setParameter("venue", filtervalue);
		}
		matchList = query.getResultList();
		return matchList;
	}



	@Override
	public List<InfEntity> MatchByTeam(String team) {
		Session session=sessionFactory.getCurrentSession();
		List<InfEntity> matchList=new ArrayList<InfEntity>();
		StringBuilder builder= new StringBuilder();
		builder.append("select i from InfEntity i where i.teams like :team ");
		Query query= session.createQuery(builder.toString());
		query.setParameter("team", "%"+team+"%");
		matchList= query.getResultList();
		return matchList;
	}


	
}
