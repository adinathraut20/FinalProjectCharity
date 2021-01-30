package com.povertyFree.povertyLessIndia.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "States")
public class States {

	@Id
	@GeneratedValue
	private int stateId;
	private String stateName;
	public States() {
		super();
	}
	public States(int stateId) {
		super();
		this.stateId = stateId;
	}
	public States(int stateId, String stateName) {
		super();
		this.stateId = stateId;
		this.stateName = stateName;
	}
	public int getStateId() {
		return stateId;
	}
	public void setStateId(int stateId) {
		this.stateId = stateId;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	@Override
	public String toString() {
		return "States [stateId=" + stateId + ", stateName=" + stateName + "]";
	}
	
	
}
