package mum.edu.DAO;

import java.util.List;

import mum.edu.models.Artist;

public interface AritistDAO {

	public List<Artist> getAllArtist();

	public Artist getArtist(int id);

	public void updateArtist(Artist artist);

	public void deleteArtist(Artist artist);
}
