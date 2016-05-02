package mum.edu.DAO;

import java.util.List;

import mum.edu.models.Movie;

public interface MovieDAO {
	
	public List<Movie> getAllMovie();

	public Movie getMovie(int id);

	public void updateMovie(Movie movie);

	public void deleteMovie(Movie movie);
}
