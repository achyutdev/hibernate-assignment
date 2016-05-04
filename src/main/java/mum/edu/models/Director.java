package mum.edu.models;

import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("director")
public class Director extends Artist {


	public Director(String name, Date dob, String birthplace, String bio, byte[] picture, List<Movie> movie) {
		super(name, dob, birthplace, bio, picture, movie);
	}

	
	
}
