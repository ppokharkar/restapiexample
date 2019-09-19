package com.ad.assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ad.assignment.model.ProjectDetails;
import com.ad.assignment.repository.ProjectRepository;

/*This service class includes methods for all the operations
 * that can be performed on Project class like save,delete,fetch
 * 
 * 
 */

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectRepository repository;

	public void setRepository(ProjectRepository repository) {
		this.repository = repository;
	}

	/*
	 * This method calls the project repository method to delete subproject
	 * associated with parent project (non-Javadoc)
	 * 
	 * @see com.fstack.managerportal.service.ProjectService#delete(java.lang.String)
	 */
	@Transactional
	@Override
	public void delete(String parentProjectId) {
		System.out.println("In service " + parentProjectId);
		repository.delete(parentProjectId);
	}

	@Override
	public List<ProjectDetails> findAll() {
		return repository.findAll();
	}

	@Override
	public ProjectDetails findOne(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProjectDetails save(ProjectDetails projectDetails) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * This method calls the project repository method to find projects, team
	 * details and employees information (non-Javadoc)
	 * 
	 * @see
	 * com.fstack.managerportal.service.ProjectService#findProjectDetails(java.lang.
	 * String)
	 */
	@Transactional(readOnly=true)
	@Override
	public List<ProjectDetails> findProjectDetails(String projectName) {
		return repository.findProjectDetails(projectName);
	}

}
