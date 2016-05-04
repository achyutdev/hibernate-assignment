package mum.edu.models;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name = "Artist_type")

public abstract class Artist {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	private Date dob;
	private String birthplace;
	private String bio;

	@Lob
	private byte[] picture;

	@ManyToMany(mappedBy = "artists")
	private List<Movie> movies;

	public Artist() {

	}

	public Artist(String name, Date dob, String birthplace, String bio, byte[] picture, List<Movie> movie) {
		this.name = name;
		this.dob = dob;
		this.birthplace = birthplace;
		this.bio = bio;
		this.picture = picture;
		this.movies = movie;
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

	public List<Movie> getMovie() {
		return movies;
	}

	public void setMovie(List<Movie> movie) {
		this.movies = movie;
	}

	@Override
	public String toString() {
		return "Artist [id=" + id + ", name=" + name + ", dob=" + dob + ", birthplace=" + birthplace + ", bio=" + bio
				+ ", picture=" + Arrays.toString(picture) + ", movies=" + movies + "]";
	}

}
