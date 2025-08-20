package com.premierleague.teamstats;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LeagueStandingsRepository extends JpaRepository < LeagueStandings, Long> {

	List<LeagueStandings> findByName(String name);




	

}
