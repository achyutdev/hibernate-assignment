package mum.edu.DAO;

import java.util.List;

import mum.edu.models.Artist;

public interface ArtistDAO {

	public List<Artist> getAllArtist();

	public Artist getArtist(int id);

	public List<Artist> getArtist(String name);
	
	public void addArtist(Artist artist);
	
	public void deleteArtist(Artist artist);
	
	public void updateArtist(Artist artist);

}
