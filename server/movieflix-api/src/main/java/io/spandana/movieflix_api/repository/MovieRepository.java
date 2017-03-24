package io.spandana.movieflix_api.repository;

import java.time.Year;
import java.util.List;

import io.spandana.movieflix_api.entity.Movie;

public interface MovieRepository {

	//CRUD operations
		public Movie create(Movie movie);

		public Movie update(Movie movie);

		public void delete(Movie movie);
		
		public Movie giveRating(String movieID, int rating);
		
		//find operations
		public List<Movie> findAll();
		
		public Movie findMovieDetails(String movieId);
		
		public List<Movie> findTopMovies();
		
		public List<Movie> findTopSeries();
		
		public Movie findAvgUserRating(String movieId);

		//filter operations
		public Movie findByType(String type);
		
		public Movie findByYear(Year year);
		
		public Movie findByGenre(String genre);
		
		//sort operations
		public List<Movie> sortByImdbRating();
		
		public List<Movie> sortByYear();
		
		public List<Movie> sortByImdbVotes();
}
