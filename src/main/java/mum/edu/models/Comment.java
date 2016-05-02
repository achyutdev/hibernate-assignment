package mum.edu.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Comment {
	
	@Id @GeneratedValue
	private int id;
	
	private String comments;
	
	@ManyToOne
	@JoinColumn(name = "movie")
	private Movie commentedMovie;
	
	

	public Comment(int id, String comments, Movie commentedMovie) {
		super();
		this.id = id;
		this.comments = comments;
		this.commentedMovie = commentedMovie;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Movie getCommentedMovie() {
		return commentedMovie;
	}

	public void setCommentedMovie(Movie commentedMovie) {
		this.commentedMovie = commentedMovie;
	}
	
	
	
	
}
