package com.premierleague.teamstats;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


//  tabable for league standings table 
/// getting the teams stats EX(team points team id etccc)
///
@Entity



public class LeagueStandings {
	public long getId() {
	    return id;
	}
	
	public Integer getRank() {
		return rank;
	}
	public void setRank(Integer rank) {
		this.rank = rank;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public int getWins() {
		return wins;
	}
	public void setWins(int wins) {
		this.wins = wins;
	}
	public int getDraws() {
		return draws;
	}
	public void setDraws(int draws) {
		this.draws = draws;
	}
	public int getLosses() {
		return losses;
	}
	public void setLosses(int losses) {
		this.losses = losses;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	//an empty constructor for JPA
	public LeagueStandings() {
		
	}
	public LeagueStandings(long id, int point, int wins, int draws, int losses, String name, Integer rank) {
		super();
		this.id = id;
		this.point = point;
		this.wins = wins;
		this.draws = draws;
		this.losses = losses;
		this.name = name;
		this.rank = rank;
	}
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;
	
	private int point;
	private int wins;
	private int draws;
	private int losses;
	private String name;
	@Column(name = "`rank`")
	private Integer rank;
	
	
}
