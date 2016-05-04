
import java.text.ParseException;
import java.util.List;

import mum.edu.models.Artist;
import mum.edu.models.Characters;
import mum.edu.models.Director;
import mum.edu.models.Genre;
import mum.edu.models.Movie;
import mum.edu.service.ArtistService;
import mum.edu.service.ArtistServiceImpl;
import mum.edu.service.MovieService;
import mum.edu.service.MovieServiceImpl;
import mum.edu.util.DataPopulate;

public class Application {

	public static void main(String[] args) throws ParseException {
		// Data populate
		DataPopulate.populate();

		// Name of the movie
		MovieService movService = new MovieServiceImpl();

		List<Movie> movies = movService.findAll();
		System.out.println("============================================");
		for (Movie movie : movies) {
			System.out.println(movie);
		}
		System.out.println("============================================");

		// Genre of the movie
		List<Movie> movies1 = movService.findAll(Genre.ACTION);
		System.out.println("============================================");
		for (Movie movie : movies1) {
			System.out.println(movie);
		}
		System.out.println("============================================");

		// Rating of the movie
		List<Movie> movies2 = movService.findAll(9);
		System.out.println("============================================");
		for (Movie movie : movies2) {
			System.out.println(movie);
		}
		System.out.println("============================================");

		// Year of the movie
		List<Movie> movies3 = movService.findAll("2016");
		System.out.println("============================================");
		for (Movie movie : movies2) {
			System.out.println(movie);
		}
		System.out.println("============================================");

		// Name of the artist
		ArtistService artistService = new ArtistServiceImpl();
		List<Artist> artists = artistService.findAll();
		System.out.println("============================================");
		for (Artist artist : artists) {
			System.out.println(artist);
		}
		System.out.println("============================================");

		// Name of the character on the movie
		List<Characters> characters = movService.findCharacters("mov1");
		System.out.println("============================================");
		for (Characters character : characters) {
			System.out.println(character.getName());
		}
		System.out.println("============================================");

		// Director of the movie
		List<Director> directors = movService.findDirector("mov1");
		System.out.println("============================================");
		for (Director director : directors) {
			System.out.println(director.getName());
		}
		System.out.println("============================================");

	}

}