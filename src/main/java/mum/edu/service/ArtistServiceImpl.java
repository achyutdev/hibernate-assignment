package mum.edu.service;

import java.util.List;

import mum.edu.DAO.ArtistDAO;
import mum.edu.models.Artist;

public class ArtistServiceImpl implements ArtistService{

	private ArtistDAO artistdao;
	public List<Artist> findAll() {
		return artistdao.getAllArtist();
	}

	public Artist find(int id) {
		return artistdao.getArtist(id);
	}

	public List<Artist> findAll(String name) {
		return artistdao.getArtist(name);
	}

	
}
