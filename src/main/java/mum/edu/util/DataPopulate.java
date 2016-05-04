package mum.edu.util;

import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import mum.edu.models.Artist;
import mum.edu.models.Characters;
import mum.edu.models.Comment;
import mum.edu.models.Director;
import mum.edu.models.Genre;
import mum.edu.models.Movie;

public class DataPopulate {
	
	@SuppressWarnings("unused")
	public static void populate() throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
		EntityManager em = EntityManagerUtil.getInstance().createEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();

		// adding movies
		byte[] poster1 = imageUpload("mov1.jpg");
		Date releaseDate1 = formatter.parse("12-Jun-2013");
		Movie mov1 = new Movie("mov 1", poster1, releaseDate1, Genre.ACTION, "mov 1 summary", null);

		byte[] poster2 = imageUpload("mov1.jpg");
		Date releaseDate2 = formatter.parse("7-Feb-2016");
		Movie mov2 = new Movie("mov 2", poster2, releaseDate2, Genre.ACTION, "mov 2 summary", null);

		em.persist(mov1);
		em.persist(mov2);

		// Adding artirts
		Date dob = formatter.parse("23-May-1982");
		byte[] picture = imageUpload("arlando.jpg");
		List<Movie> playedMov = Arrays.asList(mov1,mov2);
		Artist Orlando = new Characters("Orlando Boom", dob, "Califonia", "Awarded with grammy 4 time", picture, playedMov, "supporting Actor");
		
		
		Date dob2 = formatter.parse("23-May-1982");
		byte[] picture2 = imageUpload("leonardo-dicaprio.jpg");
		List<Movie> playedMov1 = Arrays.asList(mov2);
		Artist leonardo = new Characters("leonardo-dicaprio", dob2, "Califonia", "Best actor of all time", picture2, playedMov1, "Lead Actor");
		
		
		Date dob3 = formatter.parse("23-May-1982");
		byte[] picture3 = imageUpload("arlando.jpg");
		List<Movie> directedMov	= Arrays.asList(mov1);
		Artist Jackson = new Director("Peater Jackson", dob3, "Califonia", "Best Director.", picture3, directedMov);
		
		
		em.persist(Orlando);
		em.persist(leonardo);
		em.persist(Jackson);
		
		List<Artist> mov1Artists = Arrays.asList(Orlando,leonardo);
		List<Artist> mov2Artists = Arrays.asList(Orlando,Jackson);
		
		
		mov1.setArtists(mov1Artists);
		mov2.setArtists(mov2Artists);
		
		Comment com1 = new Comment("This movie is awesome", mov1);
		Comment com2 = new Comment("I dont like ending of this movies", mov1);
		Comment com3 = new Comment("over all good. ", mov1);
		Comment com4 = new Comment("Unbelievalbe movie. Epic movie of century.", mov2);
		
		em.persist(com1);
		em.persist(com2);
		em.persist(com3);
		em.persist(com4);
		
		tx.commit();
		
		em.close();

	}
	
	private static byte[] imageUpload(String name) {
		byte[] fileData = null;
		try {
			Path p = FileSystems.getDefault().getPath("",
					System.getProperty("user.dir") + "/src/main/resources/" + name);

			fileData = Files.readAllBytes(p);

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return fileData;
	}

}
