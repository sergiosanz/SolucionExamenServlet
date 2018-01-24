package es.salesianos.model;

import java.util.Date;


public class Company {

	private String name;
	private Date creationdate;
	
	public Company(String string) {
		this.name = string;
	}
	public Company() {}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getCreationdate() {
		return creationdate;
	}
	public void setCreationdate(Date creationdate) {
		this.creationdate = creationdate;
	}
}
	
