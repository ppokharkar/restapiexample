package com.ad.assignment.service;

import java.util.List;

import com.ad.assignment.model.ProjectDetails;

public interface ProjectService {
	void delete(String parentProjectId);

	List<ProjectDetails> findAll();

	ProjectDetails findOne(int id);

	ProjectDetails save(ProjectDetails projectDetails);

	List<ProjectDetails> findProjectDetails(String projectName);
}
