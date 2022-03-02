package com.crud.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.api.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer> {

}