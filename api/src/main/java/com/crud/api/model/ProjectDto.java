package com.crud.api.model;

import com.crud.api.entity.Project;

public class ProjectDto {
	private Integer id;
	private String name;
	private String clientName;
	private String projectManager;
	private String contactEmail;
	private Number contactNumber;
	private Number billingAddress;

	public ProjectDto() { }
	
	public ProjectDto(Project p) {
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
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
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
	public Project convertToEntity() {
		return new Project(this);
	}
}
