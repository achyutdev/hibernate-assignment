package mum.edu.DAO;

import java.util.List;

import mum.edu.models.Comment;

public interface CommentDAO {
	
	public List<Comment> getAllComment();

	public Comment getComment(int id);

	public void updateComment(Comment artist);

	public void deleteComment(Comment artist);

}
