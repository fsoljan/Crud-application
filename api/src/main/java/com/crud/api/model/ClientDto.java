package com.crud.api.model;

import com.crud.api.entity.Client;

public class ClientDto {
	private Integer id;
	private String name;
	private String country;
	private String city;
	private String streetName;
	private Number streetNumber;
	private Number zip;
	
	public ClientDto() { }

	public ClientDto(Client c) { 
		id = c.getId();
		name = c.getName();
		country = c.getCountry();
		city = c.getCity();
		streetName = c.getStreetName();
		streetNumber = c.getStreetNumber();
		zip = c.getZip();
	}
	
	public Integer getId() {
		return id;
	}
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
	public Client convertToEntity() {
		return new Client(this);
	}
}
