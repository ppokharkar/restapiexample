package com.ad.assignment.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "team_details")
public class TeamDetails implements Serializable{

	private static final long serialVersionUID = 2314685747455161249L;

	public TeamDetails() {

	}
	@Column(name = "team_name", nullable = false)
	String teamName;
	@Column(name="create_date", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable=false, updatable=false)
	Timestamp createDate;
	
	@EmbeddedId
    private TeamEmployeeID teamEmployeeID;
	
	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "project_id")
	private ProjectDetails projectDetails;
	
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade = CascadeType.ALL)
	List<Employee> employees;


	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}


	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreatedDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public ProjectDetails getProjectDetails() {
		return projectDetails;
	}

	public void setProjectDetails(ProjectDetails projectDetails) {
		this.projectDetails = projectDetails;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((projectDetails == null) ? 0 : projectDetails.hashCode());
		result = prime * result + ((teamEmployeeID == null) ? 0 : teamEmployeeID.hashCode());
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
		TeamDetails other = (TeamDetails) obj;
		if (projectDetails == null) {
			if (other.projectDetails != null)
				return false;
		} else if (!projectDetails.equals(other.projectDetails))
			return false;
		if (teamEmployeeID == null) {
			if (other.teamEmployeeID != null)
				return false;
		} else if (!teamEmployeeID.equals(other.teamEmployeeID))
			return false;
		return true;
	}

}
