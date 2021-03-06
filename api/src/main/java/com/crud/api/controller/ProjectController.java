package com.crud.api.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.crud.api.entity.Project;
import com.crud.api.model.ProjectDto;
import com.crud.api.repository.ClientRepository;
import com.crud.api.repository.ProjectRepository;

@RestController
@RequestMapping(path="/projects")
public class ProjectController {
	@Autowired
	private ProjectRepository projectRepository;
	@Autowired
	private ClientRepository clientRepository;

	@GetMapping
	public List<ProjectDto> getAll() {
		return projectRepository.findAll().stream().map(p -> p.convertToDto()).collect(Collectors.toList());
	}
	
	@GetMapping(path="/{id}")
	public ProjectDto get(@PathVariable("id") Integer projectId) {
		return projectRepository.findById(projectId).get().convertToDto();
	}

	@PostMapping
	public ProjectDto create (@RequestBody ProjectDto projectDto) {
		Project project = new Project(projectDto);
		project.setClientId(clientRepository.findByName(projectDto.getClientName()).getId());
	    return projectRepository.save(project).convertToDto();
	}

	@PatchMapping(path="/{id}")
	public ProjectDto update (@PathVariable("id") Integer projectId, @RequestBody ProjectDto projectDto) {
		Project p = projectRepository.findById(projectId).get();
		
		p.setName(projectDto.getName());
		p.setProjectManager(projectDto.getProjectManager());
		p.setContactEmail(projectDto.getContactEmail());
		p.setContactNumber(projectDto.getContactNumber());
		p.setBillingAddress(projectDto.getBillingAddress());
		
	    return projectRepository.save(p).convertToDto();
	}

	@DeleteMapping(path="/{id}")
	@ResponseStatus( HttpStatus.OK )
	public void delete (@PathVariable("id") Integer projectId) {
	    projectRepository.deleteById(projectId);
	}
	
}
