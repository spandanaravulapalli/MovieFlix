package io.spandana.movieflix_api.entity;

import java.time.Year;
import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({ 
	@NamedQuery(name = "Movie.findAll", query = "SELECT m FROM Movie m"),
	@NamedQuery(name = "Movie.findMovieDetails", query = "SELECT m FROM Movie m WHERE m.movieId=:pMovieId"), 
	@NamedQuery(name = "Movie.findMovie", query = "SELECT m FROM Movie m WHERE m.movieId=:pMovieId"),
	@NamedQuery(name = "Movie.findTopMovies", query = "SELECT m FROM Movie m WHERE m.type=:pType"),
	@NamedQuery(name = "Movie.findTopSeries", query = "SELECT m FROM Movie m WHERE m.movieId=:pType"),
	@NamedQuery(name = "Movie.findAvgUserRating", query = "SELECT (m.userRating/m.numOfRatings) as AverageRating FROM Movie m WHERE m.movieId=:pMovieId"),
	@NamedQuery(name = "Movie.findByType", query = "SELECT m FROM Movie m WHERE m.movieId=:pType"),
	@NamedQuery(name = "Movie.findByYear", query = "SELECT m FROM Movie m WHERE m.movieId=:pType"),
	@NamedQuery(name = "Movie.findByGenre", query = "SELECT m FROM Movie m WHERE m.movieId=:pGenre"),
	@NamedQuery(name = "Movie.sortByImdbRating", query = "SELECT m FROM Movie m ORDER BY m.imdbRating DESC"),
	@NamedQuery(name = "Movie.sortByYear", query = "SELECT m FROM Movie m ORDER BY m.year DESC"),
	@NamedQuery(name = "Movie.sortByImdbVotes", query = "SELECT m FROM Movie m ORDER BY m.imdbVotes DESC"),
})

public class Movie {
	
	@OneToMany(mappedBy = "Movie")
    private List<Comment> comment; 
	
	@Id
	private String movieId;
	
	//movie details
	private String title;
	private String year;
	private String released;
	private String runtime;
	private String genre;
	private String director;
	private String writer;
	private String actors;
	private String plot;
	private String language;
	private String country;
	private String awards;
	private String poster;
	private String type;
	
	//imdb details
	private int metaScore;
	private float imdbRating;
	private Long imdbVotes;
	private String imdbId;
	
	//user rating
	private float userRating;
	private Long numOfRatings;
	
	public Movie() {
		this.movieId = UUID.randomUUID().toString();
	}

	public List<Comment> getComment() {
		return comment;
	}

	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getReleased() {
		return released;
	}

	public void setReleased(String released) {
		this.released = released;
	}

	public String getRuntime() {
		return runtime;
	}

	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getActors() {
		return actors;
	}

	public void setActors(String actors) {
		this.actors = actors;
	}

	public String getPlot() {
		return plot;
	}

	public void setPlot(String plot) {
		this.plot = plot;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAwards() {
		return awards;
	}

	public void setAwards(String awards) {
		this.awards = awards;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getMetaScore() {
		return metaScore;
	}

	public void setMetaScore(int metaScore) {
		this.metaScore = metaScore;
	}

	public float getImdbRating() {
		return imdbRating;
	}

	public void setImdbRating(float imdbRating) {
		this.imdbRating = imdbRating;
	}

	public Long getImdbVotes() {
		return imdbVotes;
	}

	public void setImdbVotes(Long imdbVotes) {
		this.imdbVotes = imdbVotes;
	}

	public String getImdbId() {
		return imdbId;
	}

	public void setImdbId(String imdbId) {
		this.imdbId = imdbId;
	}

	public float getUserRating() {
		return userRating;
	}

	public void setUserRating(float userRating) {
		this.userRating = userRating;
	}

	public Long getNumOfRatings() {
		return numOfRatings;
	}

	public void setNumOfRatings(Long numOfRatings) {
		this.numOfRatings = numOfRatings;
	}
	
}
