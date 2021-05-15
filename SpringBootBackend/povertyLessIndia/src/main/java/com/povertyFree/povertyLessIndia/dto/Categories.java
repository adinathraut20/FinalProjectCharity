package com.povertyFree.povertyLessIndia.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Categories")
public class Categories {
	
	@Id
	@GeneratedValue
	private int categoryId;
	private String categoryName;
	private String unit;
	
	public Categories() {}

	public Categories(int categoryId) {
		super();
		this.categoryId = categoryId;
	}

	public Categories(int categoryId, String categoryName, String unit) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.unit = unit;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	@Override
	public String toString() {
		return "Categories [categoryId=" + categoryId + ", categoryName=" + categoryName + ", unit=" + unit + "]";
	}


}