package mum.edu.DAO;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import mum.edu.models.Characters;
import mum.edu.models.Director;
import mum.edu.models.Genre;
import mum.edu.models.Movie;
import mum.edu.util.EntityManagerUtil;

public class MovieDAOImp implements MovieDAO{

	EntityManager em = EntityManagerUtil.getInstance().createEntityManager();
	EntityTransaction tx = em .getTransaction();
	
	public List<Movie> getAllMovie() {
		tx.begin();
		Query query = em.createQuery("FROM Movie ");
		List<Movie> movies = query.getResultList();
		em.close();
		return movies;
	}

	public Movie getMovie(int id) {
		tx.begin();
		Query query = em.createQuery("SELECT a FROM Movie a WHERE a.id = :id");
		query.setParameter(0, id);
		Movie movie = (Movie) query.getSingleResult();
		em.close();
		return movie;
	}

	public List<Movie> getAllMovieGenre(Genre genre) {
		tx.begin();
		Query query = em.createQuery("SELECT a FROM Movie a WHERE a.genre = :genre");
		query.setParameter(0, genre);
		List<Movie> movies = query.getResultList();
		em.close();
		return movies;
	}

	public List<Movie> getAllMovieRating(int rating) {
		tx.begin();
		Query query = em.createQuery("SELECT a FROM Movie a WHERE a.rating = :rating");
		query.setParameter(0, rating);
		List<Movie> movies = query.getResultList();
		em.close();
		return movies;
	}

	public List<Movie> getAllMovieYear(Date date) {
		tx.begin();
		Query query = em.createQuery("SELECT a FROM Movie a WHERE a.date = :date");
		query.setParameter(0, date);
		List<Movie> movies = query.getResultList();
		em.close();
		return movies;
	}

	public List<Characters> findAllCharacters(String movName) {
		tx.begin();
		Query query = em.createQuery("SELECT m.artists FROM Movie m where m.name = :movName ");
		query.setParameter(0, movName);
		List<Characters> characters = (List<Characters>)query.getResultList();
		em.close();
		return characters;
	}

	public List<Director> findAllDirector(String movieName) {
		tx.begin();
		Query query = em.createQuery("SELECT m.artists FROM Movie m where m.name = :movName ");
		query.setParameter(0, movieName);
		List<Director> directors = (List<Director>)query.getResultList();
		em.close();
		return directors;
	}

}
