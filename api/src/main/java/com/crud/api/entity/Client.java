package com.crud.api.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.crud.api.model.ClientDto;

@Entity
@NamedQuery(name = "Project.findByName", query = "SELECT c FROM Client c WHERE c.name = ?1")
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

	public Client() { }

	public Client(ClientDto c) { 
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
	public void setId(Integer id) {
		this.id = id;
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
	
	public ClientDto convertToDto() {
		return new ClientDto(this);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		return Objects.equals(id, other.id);
	}

}
