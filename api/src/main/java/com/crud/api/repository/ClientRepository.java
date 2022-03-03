package com.crud.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.api.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {
	public Client findByName(String name);
}