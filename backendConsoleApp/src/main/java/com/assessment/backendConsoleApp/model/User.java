package com.assessment.backendConsoleApp.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4164767467056942790L;
	
	private String user_id;
	private BigDecimal sum;
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public BigDecimal getSum() {
		return sum;
	}
	public void setSum(BigDecimal sum) {
		this.sum = sum;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sum == null) ? 0 : sum.hashCode());
		result = prime * result + ((user_id == null) ? 0 : user_id.hashCode());
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
		User other = (User) obj;
		if (sum == null) {
			if (other.sum != null)
				return false;
		} else if (!sum.equals(other.sum))
			return false;
		if (user_id == null) {
			if (other.user_id != null)
				return false;
		} else if (!user_id.equals(other.user_id))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", sum=" + sum + "]";
	}
	
}
