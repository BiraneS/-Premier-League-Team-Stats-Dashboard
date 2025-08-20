package com.premierleague.teamstats;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


// this class will get the players infos ex(player club, position etc..)


@Entity
public class PlayersInfo {
	//Empty constructor for JPA
	public  PlayersInfo() {
		
	}
	
	public PlayersInfo(long id, String club, String position, String nationality, int seasonGoals, String playerName) {
		super();
		this.id = id;
		this.club = club;
		this.position = position;
		this.nationality = nationality;
		this.seasonGoals = seasonGoals;
		this.playerName = playerName;
	}
	public String getClub() {
		return club;
	}
	public void setClub(String club) {
		this.club = club;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public int getSeasonGoals() {
		return seasonGoals;
	}
	public void setSeasonGoals(int seasonGoals) {
		this.seasonGoals = seasonGoals;
	}
	
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;
	private String club;
	private String position;
	private String nationality;
	private int seasonGoals;
	private String playerName;
	

}
