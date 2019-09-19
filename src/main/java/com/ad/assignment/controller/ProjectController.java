package com.ad.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ad.assignment.model.ProjectDetails;
import com.ad.assignment.service.ProjectService;

@RequestMapping({ "/projects" })
@RestController

public class ProjectController {

	@Autowired
	private ProjectService projectService;

	/*
	 * This DELETE method will accept the parentProjectId as input path parameter
	 * and deletes subproject only without deleting parent project
	 */
	@DeleteMapping(path = { "/{id}" })
	public ResponseEntity<Void> deleteSubProjects(@PathVariable("id") String parentProjectId) {
		System.out.println("In Controller " + parentProjectId);
		projectService.delete(parentProjectId);
		return ResponseEntity.ok().build();

	}

	/*
	 * This GET method will all the available project information including team
	 * name and team details
	 */
	@GetMapping()
	public ResponseEntity<List<ProjectDetails>> getProjectInformation() {
		List<ProjectDetails> projectDetails = projectService.findAll();
		if (projectDetails != null) {
			return ResponseEntity.status(HttpStatus.OK).body(projectDetails);
		}

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(projectDetails);

	}

}
