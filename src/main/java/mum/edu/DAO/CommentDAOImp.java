package mum.edu.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import mum.edu.models.Comment;
import mum.edu.util.EntityManagerUtil;

public class CommentDAOImp implements CommentDAO {
	EntityManager em = EntityManagerUtil.getInstance().createEntityManager();
	EntityTransaction tx = em .getTransaction();

	
	public List<Comment> getAllComment() {
		tx.begin();
		Query query = em.createQuery("FROM Comment ");
		List<Comment> comments = query.getResultList();
		em.close();
		return comments;
	}

	public Comment getComment(int id) {
		tx.begin();
		Query query = em.createQuery("SELECT a FROM Comment a WHERE a = :id");
		query.setParameter(0, id);
		Comment comment = (Comment) query.getSingleResult();
		em.close();
		return comment;
	}

	public void updateComment(Comment artist) {
		// TODO Auto-generated method stub
		
	}

	public void deleteComment(Comment artist) {
		// TODO Auto-generated method stub
		
	}

}
