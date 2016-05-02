package mum.edu.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Movie {
	
	@Id @GeneratedValue
	private int id;
	private String title;
	
	@Lob
	private byte[] poster;
	
	@Temporal(TemporalType.DATE)
	private Date releaseDate;
	
	@Enumerated(EnumType.STRING)
	private Genre genre;
	private String summary;
	
	@OneToMany(mappedBy="commentedMovie")
	private List<String> comments;

	
	
	public Movie(String title, byte[] poster, Date releaseDate, Genre genre, String summary,
			List<String> comments) {
		this.title = title;
		this.poster = poster;
		this.releaseDate = releaseDate;
		this.genre = genre;
		this.summary = summary;
		this.comments = comments;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public byte[] getPoster() {
		return poster;
	}

	public void setPoster(byte[] poster) {
		this.poster = poster;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public List<String> getComments() {
		return comments;
	}

	public void setComments(List<String> comments) {
		this.comments = comments;
	}
	
	
	
	
}
