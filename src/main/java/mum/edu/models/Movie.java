package mum.edu.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
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
	
	private int rating;
	

	@Temporal(TemporalType.DATE)
	private Date releaseDate;
	
	@Enumerated(EnumType.STRING)
	private Genre genre;
	private String summary;
	
	@OneToMany(mappedBy="movie")
	private List<Comment> comments;
	
	 @ManyToMany
	  @JoinTable(
	      name="mov_art",
	      joinColumns=@JoinColumn(name="movie_ID"),
	      inverseJoinColumns=@JoinColumn(name="artist_ID"))
	private List<Artist> artists;

	public Movie(){
		
	}
	

	public Movie(String title, byte[] poster, Date releaseDate,int rating, Genre genre, String summary,List<Artist> artists) {
		this.title = title;
		this.poster = poster;
		this.releaseDate = releaseDate;
		this.rating =rating;
		this.genre = genre;
		this.summary = summary;
		this.artists =artists;
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

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
	
	public List<Artist> getArtists() {
		return artists;
	}
	
	public void setArtists(List<Artist> artists) {
		this.artists = artists;
	}


	public int getRating() {
		return rating;
	}


	public void setRating(int rating) {
		this.rating = rating;
	}


	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", rating=" + rating + ", releaseDate=" + releaseDate
				+ ", genre=" + genre + ", summary=" + summary + "]";
	}
	
	

}
