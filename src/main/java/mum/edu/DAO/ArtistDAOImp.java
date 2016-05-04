package mum.edu.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import mum.edu.models.Artist;
import mum.edu.util.EntityManagerUtil;

public class ArtistDAOImp implements ArtistDAO {

	EntityManager em = EntityManagerUtil.getInstance().createEntityManager();
	EntityTransaction tx = em.getTransaction();

	public List<Artist> getAllArtist() {
		tx.begin();
		Query query = em.createQuery("FROM Artist ");
		List<Artist> artists = query.getResultList();
		em.close();
		return artists;
	}

	public Artist getArtist(int id) {
		tx.begin();
		Query query = em.createQuery("SELECT a FROM Artist a WHERE a = :id");
		query.setParameter(0, id);
		Artist artist = (Artist) query.getSingleResult();
		em.close();
		return artist;
	}

	public List<Artist> getArtist(String name) {
		tx.begin();
		Query query = em.createQuery("SELECT a FROM Artist a WHERE a = :name");
		query.setParameter(0, name);
		List<Artist> artists = query.getResultList();
		em.close();
		return artists;
	}

}
