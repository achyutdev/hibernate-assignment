

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;


import org.apache.log4j.Logger;


public class Application {
	private static Logger logger = Logger.getLogger(Application.class);

	private static final EntityManagerFactory emf;

	static {
		try {
			emf = Persistence.createEntityManagerFactory("jpt");
		} catch (Throwable ex) {
			ex.printStackTrace();
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static void main(String[] args) {

		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Query query = em.createQuery("from movie");
		logger.trace("All flights leaving before 12pm on 08/07/2009 ");
		query.getFirstResult();
		tx.commit();
		
		emf.close();

	}
}