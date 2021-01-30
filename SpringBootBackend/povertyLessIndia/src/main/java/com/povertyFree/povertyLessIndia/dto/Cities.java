package com.povertyFree.povertyLessIndia.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Cities")
public class Cities {

	
	@Id
	@GeneratedValue
	private int cityId;
	private String cityName;
	@ManyToOne
	@JoinColumn(name = "stateId")
	private States state;
	
	public Cities() {
		super();
	}

	public Cities(int cityId) {
		super();
		this.cityId = cityId;
	}

	public Cities(int cityId, String cityName, States state) {
		super();
		this.cityId = cityId;
		this.cityName = cityName;
		this.state = state;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public States getState() {
		return state;
	}

	public void setState(States state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Cities [cityId=" + cityId + ", cityName=" + cityName + ", state=" + state + "]";
	}
	
	
}
