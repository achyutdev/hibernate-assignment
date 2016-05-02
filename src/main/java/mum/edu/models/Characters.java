package mum.edu.models;

import java.util.Date;

public class Characters extends Artist{

	private String role;
	
	public Characters(String name, Date dob, String birthplace, String bio, byte[] picture, Movie movie,String role) {
		super(name, dob, birthplace, bio, picture, movie);
		this.role = role;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
}
