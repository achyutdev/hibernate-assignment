
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;

import mum.edu.models.Genre;
import mum.edu.models.Movie;

public class Application {
	private static Logger logger = Logger.getLogger(Application.class);

	private static final EntityManagerFactory emf;

	static {
		try {
			emf = Persistence.createEntityManagerFactory("movieimdb");
		} catch (Throwable ex) {
			ex.printStackTrace();
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static void main(String[] args) throws ParseException {

		addData();
		
//		queries
		
		
		emf.close();

	}

	private static void addData() throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();

		// adding movies
		byte[] poster1 = imageUpload("mov1.jpg");
		Date releaseDate1 = formatter.parse("12-Jun-2013");
		Movie mov1 = new Movie("mov 1", poster1, releaseDate1, Genre.ACTION, "mov 1 summary",null);

		byte[] poster2 = imageUpload("mov2.JPG");
		Date releaseDate2 = formatter.parse("7-Feb-2016");
		Movie mov2 = new Movie("mov 2", poster2, releaseDate2, Genre.ACTION, "mov 2 summary",null);

		em.persist(mov1);
		em.persist(mov2);
		
//		Adding artirts 
		

		tx.commit();

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