package com.crud.api.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Client {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String name;
	private String country;
	private String city;
	private String streetName;
	private Number streetNumber;
	private Number zip;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public Number getStreetNumber() {
		return streetNumber;
	}
	public void setStreetNumber(Number streetNumber) {
		this.streetNumber = streetNumber;
	}
	public Number getZip() {
		return zip;
	}
	public void setZip(Number zip) {
		this.zip = zip;
	}
}
