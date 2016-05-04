package mum.edu.service;

import java.util.List;

import mum.edu.models.Artist;


public interface ArtistService {
	
	List<Artist> findAll();

	Artist find(int id);

	List<Artist> findAll(String name);


}
