package com.ad.assignment.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "project_details")
public class ProjectDetails implements Serializable {

	private static final long serialVersionUID = 1407839759947902513L;

	public ProjectDetails() {

	}

	@Id
	@Column(name = "project_id", nullable = false)
	int projectId;
	@Column(name = "project_name")
	String projectName;
	@Column(name = "project_start_date")
	Timestamp projectStartDate;
	@Column(name="create_date", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable=false, updatable=false)
	Timestamp createDate;
	
    @JoinColumn(name="parent_project_id")
    public String parentProjectId;
	
	 @OneToMany(mappedBy="parentProjectId",orphanRemoval=true)
	 public List<ProjectDetails> subProjects = new ArrayList<ProjectDetails>();

	


	public String getParentProjectId() {
		return parentProjectId;
	}

	public void setParentProjectId(String parentProjectId) {
		this.parentProjectId = parentProjectId;
	}

	public List<ProjectDetails> getSubProjects() {
		return subProjects;
	}

	public void setSubProjects(List<ProjectDetails> subProjects) {
		this.subProjects = subProjects;
	}


	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Timestamp getProjectStartDate() {
		return projectStartDate;
	}

	public void setProjectStartDate(Timestamp projectStartDate) {
		this.projectStartDate = projectStartDate;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy="teamEmployeeID.teamId" ,cascade = CascadeType.ALL,orphanRemoval = true)
	List<TeamDetails> teamDetails;

	public List<TeamDetails> getTeamDetails() {
		return teamDetails;
	}

	public void setTeamDetails(List<TeamDetails> teamDetails) {
		this.teamDetails = teamDetails;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((parentProjectId == null) ? 0 : parentProjectId.hashCode());
		result = prime * result + projectId;
		result = prime * result + ((teamDetails == null) ? 0 : teamDetails.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProjectDetails other = (ProjectDetails) obj;
		if (parentProjectId == null) {
			if (other.parentProjectId != null)
				return false;
		} else if (!parentProjectId.equals(other.parentProjectId))
			return false;
		if (projectId != other.projectId)
			return false;
		if (teamDetails == null) {
			if (other.teamDetails != null)
				return false;
		} else if (!teamDetails.equals(other.teamDetails))
			return false;
		return true;
	}


}
