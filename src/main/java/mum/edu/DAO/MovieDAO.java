package mum.edu.DAO;

import java.util.Date;
import java.util.List;

import mum.edu.models.Characters;
import mum.edu.models.Director;
import mum.edu.models.Genre;
import mum.edu.models.Movie;

public interface MovieDAO {
	
	public List<Movie> getAllMovie();

	public Movie getMovie(int id);

	public List<Movie> getAllMovieGenre(Genre genre);

	public List<Movie> getAllMovieRating(int rating);

	public List<Movie> getAllMovieYear(Date date);

	public List<Characters> findAllCharacters(String characterName);

	public List<Director> findAllDirector(String movieName);
}
