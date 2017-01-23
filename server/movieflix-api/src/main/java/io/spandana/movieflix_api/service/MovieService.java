package io.spandana.movieflix_api.service;

import java.time.Year;
import java.util.List;

import io.spandana.movieflix_api.entity.Movie;

public interface MovieService {

	//CRUD operations
	public Movie create(Movie movie);

	public Movie update(String movieId, Movie movie);

	public void delete(String movieId);
	
	public Movie giveRating(String movieID, int rating);
	
	//find operations
	public List<Movie> findAll();
	
	public Movie findMovieDetails(String movieId);
	
	public List<Movie> findTopMovies();
	
	public List<Movie> findTopSeries();
	
	public Movie findAvgUserRating(String movieId);

	//filter operations
	public List<Movie> findByType(String type);
	
	public List<Movie> findByYear(Year year);
	
	public List<Movie> findByGenre(String genre);
	
	//sort operations
	public List<Movie> sortByImdbRating();
	
	public List<Movie> sortByYear();
	
	public List<Movie> sortByImdbVotes();
	
}
