package com.premierleague.teamstats;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
//api call for league standings using the http method"crud"
//Get, Post,Put,Delete
//need that for rank, wins , draws, losses, points, name
//call external apis
@RestController

public class LeagueStandingsController {
	@Autowired
private LeagueStandingsService leagueStandingsService;
	
@GetMapping("/LeagueStandings/name/{name}")
	
	public ResponseEntity<String>  getName(@PathVariable String name) {
	
	 LeagueStandings playerName = leagueStandingsService.saveName(name);
		
		return ResponseEntity.ok(name);
				
	}
	
	@GetMapping("/LeagueStandings/")
	public ResponseEntity<List> getLeagueStandings() {
		List<LeagueStandings> AllLeagueStandings = leagueStandingsService.getAllLeagueStandings();
		return ResponseEntity.ok(AllLeagueStandings);
		
	}
	//create
	@PostMapping("/LeagueStandings/")
	public ResponseEntity<LeagueStandings> createLeagueStandings(@RequestBody LeagueStandings leagueStandings) {
		LeagueStandings createtLeagueStandings = leagueStandingsService.createLeagueStandings(leagueStandings);
		
		return ResponseEntity.ok(createtLeagueStandings);
		
	}
	//updating
	@PutMapping("/LeagueStandings/{id}")
	public ResponseEntity<LeagueStandings> updateLeagueStandings( @PathVariable long id,@RequestBody LeagueStandings updatedId) {
		
		LeagueStandings update = leagueStandingsService.updateLeagueStandings(id,updatedId);
		
		return ResponseEntity.ok(update);		
	}
	//delete
	
	@DeleteMapping("/LeagueStandings/{id}")
	public ResponseEntity<LeagueStandings> deletedLeagueStandings(@PathVariable long id){
		leagueStandingsService.deleteLeagueStandings(id);
		
		return ResponseEntity.noContent().build();
	}
	@GetMapping("/external")
	public ResponseEntity<String> getExternalData() {
	    String externalData = leagueStandingsService.fetchFromExternalApi();
	    return ResponseEntity.ok(externalData);
	}
	
	
	
	
}
