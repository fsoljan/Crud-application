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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.crud.api.entity.Client;
import com.crud.api.model.ClientDto;
import com.crud.api.repository.ClientRepository;

@RestController
@RequestMapping(path="/clients")
public class ClientController {
	@Autowired
	private ClientRepository clientRepository;
	
	@GetMapping
	public List<ClientDto> getAll() {
		return clientRepository.findAll().stream().map(c -> c.convertToDto()).collect(Collectors.toList());
	}

	@GetMapping(path="/{id}")
	public ClientDto get(@PathVariable("id") Integer clientId) {
		return clientRepository.findById(clientId).get().convertToDto();
	}

	@PostMapping
	public @ResponseBody ClientDto create (@RequestBody ClientDto clientDto) {
	    return clientRepository.save(clientDto.convertToEntity()).convertToDto();
	}

	@PatchMapping(path="/{id}")
	public @ResponseBody ClientDto update (@PathVariable("id") Integer clientId, @RequestBody ClientDto clientDto) {
		Client c = clientRepository.findById(clientId).get();
		
		c.setName(clientDto.getName());
		c.setCountry(clientDto.getCountry());
		c.setCity(clientDto.getCity());
		c.setStreetName(clientDto.getStreetName());
		c.setStreetNumber(clientDto.getStreetNumber());
		c.setZip(clientDto.getZip());
		
	    return clientRepository.save(c).convertToDto();
	}

	@DeleteMapping(path="/{id}")
	@ResponseStatus( HttpStatus.OK )
	public void delete (@PathVariable("id") Integer projectId) {
	    clientRepository.deleteById(projectId);
	}
	
}
