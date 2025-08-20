package com.premierleague.teamstats;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TeamInfo {
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public String getStaduimInfo() {
		return staduimInfo;
	}
	public void setStaduimInfo(String staduimInfo) {
		this.staduimInfo = staduimInfo;
	}
	public String getSquad() {
		return squad;
	}
	public void setSquad(String squad) {
		this.squad = squad;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	//Empty constructor for JPA
		public  TeamInfo() {
			
		}
	public TeamInfo(long id, String manager, String staduimInfo, String squad, String teamName) {
		super();
		this.id = id;
		this.manager = manager;
		this.staduimInfo = staduimInfo;
		this.squad = squad;
		this.teamName = teamName;
	}
	
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;
	private String manager;
	private String staduimInfo;
	private String squad;
	private String teamName;
	

}
