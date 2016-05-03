package mum.edu.service;

import java.util.List;

import mum.edu.DAO.MovieDAO;
import mum.edu.DAO.MovieDAOImp;
import mum.edu.models.Movie;

public class MovieServiceImpl implements MovieService {

	private MovieDAO movieDAO = new MovieDAOImp();
	
	/* (non-Javadoc)
	 * @see mum.edu.service.MovieService#findAll()
	 */
	public List<Movie> findAll(){
		return movieDAO.getAllMovie();
	}
	
	
}
