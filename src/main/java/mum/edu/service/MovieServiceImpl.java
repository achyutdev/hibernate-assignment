package mum.edu.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import mum.edu.DAO.MovieDAO;
import mum.edu.DAO.MovieDAOImp;
import mum.edu.models.Characters;
import mum.edu.models.Director;
import mum.edu.models.Genre;
import mum.edu.models.Movie;

public class MovieServiceImpl implements MovieService {
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
	private MovieDAO movieDAO = new MovieDAOImp();
	
	public List<Movie> findAll(){
		return movieDAO.getAllMovie();
	}
	
	public Movie find(int id){
		return movieDAO.getMovie(id);
	}
	
	public List<Movie> findAll(Genre genre){
		return movieDAO.getAllMovieGenre(genre);
	}
	
	
	public List<Movie> findAll(int rating){
		return movieDAO.getAllMovieRating(rating);
	}
	
	
	public List<Movie> findAll(String date){
		Date dateformated = null;
		try {
			dateformated = formatter.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return movieDAO.getAllMovieYear(dateformated);
	}

	public List<Characters> findCharacters(String movieName) {
		return movieDAO.findAllCharacters(movieName);
	}

	
	public List<Director> findDirector(String movieName) {
		return movieDAO.findAllDirector(movieName);
	}

	
	
}
