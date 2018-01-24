package es.salesianos.model;

import java.util.Date;

public class Videogame {

	private String title;	
	private int age;
	private Date RelDate;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getRelDate() {
		return RelDate;
	}
	public void setRelDate(Date relDate) {
		RelDate = relDate;
	}	
}
