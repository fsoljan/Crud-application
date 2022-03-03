package com.crud.api.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.crud.api.model.ProjectDto;

@Entity
public class Project {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@NotBlank
	private String name;
	@Min(0)
	private Integer clientId = -1;
	@NotBlank
	private String projectManager;
	private String contactEmail;
	private Number contactNumber;
	@Min(1)
	private Number billingAddress = -1;
	
	public Project() { }
	
	public Project(ProjectDto p) {
		this.id = p.getId();
		this.name = p.getName();
		this.projectManager = p.getProjectManager();
		this.contactEmail = p.getContactEmail();
		this.contactNumber = p.getContactNumber();
		this.billingAddress = p.getBillingAddress();
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
	public Integer getClientId() {
		return clientId;
	}
	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}
	public String getProjectManager() {
		return projectManager;
	}
	public void setProjectManager(String projectManager) {
		this.projectManager = projectManager;
	}
	public String getContactEmail() {
		return contactEmail;
	}
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}
	public Number getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(Number contactNumber) {
		this.contactNumber = contactNumber;
	}
	public Number getBillingAddress() {
		return billingAddress;
	}
	public void setBillingAddress(Number billingAddress) {
		this.billingAddress = billingAddress;
	}
	public ProjectDto convertToDto() {
		return new ProjectDto(this);
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
		Project other = (Project) obj;
		return Objects.equals(id, other.id);
	}
}
