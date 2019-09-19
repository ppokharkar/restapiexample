package com.ad.assignment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.ad.assignment.model.ProjectDetails;

public interface ProjectRepository extends Repository<ProjectDetails, Integer> {

	@Modifying
	@Query("DELETE FROM ProjectDetails p WHERE p.parentProjectId = :parentProjectId)")
	void delete(@Param("parentProjectId") String parentProjectId);

	List<ProjectDetails> findAll();

	ProjectDetails findOne(int id);

	ProjectDetails save(ProjectDetails project);

	@Query("SELECT p FROM ProjectDetails p WHERE p.projectName = :projectName)")
	List<ProjectDetails> findProjectDetails(@Param("projectName") String projectName);

}
