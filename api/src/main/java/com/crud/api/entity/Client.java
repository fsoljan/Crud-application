package com.crud.api.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;


@Entity
public class Client {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@NotBlank
	private String name;
	@NotBlank
	private String country;
	@NotBlank
	private String city;
	@NotBlank
	private String streetName;
	@Min(1)
	private Number streetNumber = 0;
	@Min(1)
	private Number zip = 0;
	
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
