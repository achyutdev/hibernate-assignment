package mum.edu.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class Artist {
	
	@Id @GeneratedValue
	private int id;
	private String name;
	private Date dob;
	private String birthplace;
	private String bio;
	
	@Lob
	private byte[] picture;
	
	@ManyToOne
	@JoinColumn(name = "movie")
	private Movie movie;
	
	

	public Artist( String name, Date dob, String birthplace, String bio, byte[] picture, Movie movie) {
		this.name = name;
		this.dob = dob;
		this.birthplace = birthplace;
		this.bio = bio;
		this.picture = picture;
		this.movie = movie;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getBirthplace() {
		return birthplace;
	}

	public void setBirthplace(String birthplace) {
		this.birthplace = birthplace;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	
	
	
}
