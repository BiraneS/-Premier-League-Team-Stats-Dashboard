package com.premierleague.teamstats;

import java.net.URI;

import java.util.List;


import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service 
public class LeagueStandingsService {
	@Autowired
	public LeagueStandingsRepository leagueStandingsRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	public LeagueStandings saveName(String name) {
		// TODO Auto-generated method stub
		LeagueStandings standings = new LeagueStandings();
		 standings.setName(name);
		return leagueStandingsRepository.save(standings);
	}
	
public LeagueStandings findLeagueStandingsById(long id) {
	
	Optional<LeagueStandings> leagueid =  leagueStandingsRepository.findById(id);
	
	return leagueid.orElse(new LeagueStandings());
}


public List<LeagueStandings> getAvailableLeagueStandingsByName(String name){
	List<LeagueStandings> allLeagueStandings = leagueStandingsRepository.findByName(name);
	
	return 	allLeagueStandings.stream()
			.collect(Collectors.toList());
	
}

public LeagueStandings saveLeagueStandings(Integer rank, int point , int wins,
		int losses, int draws, String name) {
	
	LeagueStandings LSTD = new 	LeagueStandings();
	
	LSTD.setDraws(draws);
	LSTD.setLosses(losses);
LSTD.setName(name);
LSTD.setPoint(point);
LSTD.setRank(rank);
LSTD.setWins(wins);
leagueStandingsRepository.save(LSTD);
	return LSTD;
	
	
	
}
//reading

public List<LeagueStandings> getAllLeagueStandings() {
	List<LeagueStandings> allStandings = leagueStandingsRepository.findAll();
	
	return allStandings ;
}

//creating
public LeagueStandings createLeagueStandings(LeagueStandings leagueStandings) {
	
	
	LeagueStandings theLeagueStandings = leagueStandingsRepository.save(leagueStandings);
	
	return theLeagueStandings;
}

//updating

//Find the existing record by ID
//Update its fields with the new values
//Save it back to the database


public LeagueStandings updateLeagueStandings(long id, LeagueStandings updatedId) {
	// TODO Auto-generated method stub
	
	LeagueStandings existing = leagueStandingsRepository.findById(id).orElseThrow();
	
	existing.setName(updatedId.getName());
	existing.setDraws(updatedId.getDraws());
	existing.setLosses(updatedId.getLosses());
	existing.setPoint(updatedId.getPoint());
	existing.setRank(updatedId.getRank());
	existing.setWins(updatedId.getWins());
	
	leagueStandingsRepository.save(existing);
	
	return existing;
	
}

public void deleteLeagueStandings(long id) {
	// TODO Auto-generated method stub
	leagueStandingsRepository.deleteById(id);
}

//call external api to get league standings
// Used https://api.msmc.cc/premier/ to find the base url
//public List<LeagueStandings> fetchFromExternalApi()
public String fetchFromExternalApi() {
    return restTemplate.getForObject(
        "https://www.thesportsdb.com/api/v1/json/123/lookuptable.php?l=4328&s=2024-2025", 
        String.class);
}

}
