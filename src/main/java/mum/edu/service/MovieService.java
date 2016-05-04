package mum.edu.service;

import java.util.List;

import mum.edu.models.Characters;
import mum.edu.models.Director;
import mum.edu.models.Genre;
import mum.edu.models.Movie;

public interface MovieService {
	
	List<Movie> findAll();

	Movie find(int id);

	List<Movie> findAll(Genre genre);

	List<Movie> findAll(int rating);

	List<Movie> findAll(String date);

	List<Characters> findCharacters(String string);

	List<Director> findDirector(String string);

}