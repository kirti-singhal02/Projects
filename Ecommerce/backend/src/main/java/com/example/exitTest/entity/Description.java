package com.example.exitTest.entity;

import java.util.Date;

import org.hibernate.annotations.ValueGenerationType;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;

@Entity
public class Description {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer desId;
	String desColor;
	String desGender;
	
	String desSize;
	String desDate;
	@OneToOne(fetch = FetchType.LAZY)
	private Product product;
	
	public Integer getDesId() {
		return desId;
	}

	public void setDesId(Integer desId) {
		this.desId = desId;
	}

	public String getDesColor() {
		return desColor;
	}

	public void setDesColor(String desColor) {
		this.desColor = desColor;
	}

	public String getDesGender() {
		return desGender;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public void setDesGender(String desGender) {
		this.desGender = desGender;
	}

	

	

	public String getDesSize() {
		return desSize;
	}

	public void setDesSize(String desSize) {
		this.desSize = desSize;
	}

	public String getDesDate() {
		return desDate;
	}

	public void setDesDate(String date) {
		this.desDate = date;
	}

	public Description( String desColor, String desGender, String desSize,
			String desDate) {
		super();
		
		this.desColor = desColor;
		this.desGender = desGender;
		
		this.desSize = desSize;
		this.desDate = desDate;
	}

	public Description() {
		super();
	}

	

}
