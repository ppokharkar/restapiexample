package com.ad.assignment.model;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TeamEmployeeID implements Serializable{
	    /**
	 * 
	 */
	private static final long serialVersionUID = -2743663974108751611L;
	 	@Column(name = "team_id")
		private String teamId;
	 	 @Column(name = "employee_id")
	    private BigInteger employeeId;
	 
	    public TeamEmployeeID() {
	    }
	
	    public TeamEmployeeID(String teamId, BigInteger employeeId) {
	        this.teamId = teamId;
	        this.employeeId = employeeId;
	    }

		public String getTeamId() {
			return teamId;
		}

		public void setTeamId(String teamId) {
			this.teamId = teamId;
		}

		public BigInteger getEmployeeId() {
			return employeeId;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((employeeId == null) ? 0 : employeeId.hashCode());
			result = prime * result + ((teamId == null) ? 0 : teamId.hashCode());
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
			TeamEmployeeID other = (TeamEmployeeID) obj;
			if (employeeId == null) {
				if (other.employeeId != null)
					return false;
			} else if (!employeeId.equals(other.employeeId))
				return false;
			if (teamId == null) {
				if (other.teamId != null)
					return false;
			} else if (!teamId.equals(other.teamId))
				return false;
			return true;
		}

		public void setEmployeeId(BigInteger employeeId) {
			this.employeeId = employeeId;
		}
	    
	    
	 
}
