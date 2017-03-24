package io.spandana.movieflix_api.controller;

import java.time.Year;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.spandana.movieflix_api.entity.Movie;
import io.spandana.movieflix_api.entity.User;
import io.spandana.movieflix_api.service.MovieService;
import io.spandana.movieflix_api.service.UserService;

@RestController
@RequestMapping(value = "movies")
public class MovieController {
	
	@Autowired
	private MovieService service;

	//FIND ALL
	@RequestMapping(method = RequestMethod.GET)
	public List<Movie> findAll() {
		return service.findAll();
	}
	
	//CREATE
	@RequestMapping(method = RequestMethod.POST)
	public Movie create(@RequestBody Movie movie) {
		return service.create(movie);
	}
	
	//UPDATE
	@RequestMapping(method = RequestMethod.PUT, value = "{movieId}")
	public Movie update(@PathVariable("movieId") String movieId, @RequestBody Movie movie) {
		return service.update(movieId, movie);
	}
	
	//DELETE
	@RequestMapping(method = RequestMethod.DELETE, value = "{movieId}")
	public void delete(@PathVariable("movieId") String movieId) {
		service.delete(movieId);
	}
	
	//GIVE RATING
	@RequestMapping(method = RequestMethod.PUT, value = "{movieId}/{rating}")
	public Movie giveRating(@PathVariable("movieId") String movieId, @PathVariable("rating") int rating, @RequestBody Movie movie) {
		return service.giveRating(movieId, rating);
	}
	
	//FIND MOVIE DETAILS
	@RequestMapping(method = RequestMethod.GET, value = "{movieId}")
	public Movie findMovieDetails(@PathVariable("movieId") String movieId) {
		return service.findMovieDetails(movieId);
	}
	
	//FIND TOP MOVIES
	@RequestMapping(method = RequestMethod.GET, value = "type/movie")
	public List<Movie> findTopMovies() {
		return service.findTopMovies();
	}
	
	//FIND TOP SERIES
	@RequestMapping(method = RequestMethod.GET, value = "type/series")
	public List<Movie> findTopSeries() {
		return service.findTopSeries();
	}
	
	//FIND AVG USER RATING
	@RequestMapping(method = RequestMethod.GET, value = "movieId/{movieId}")
	public Movie findAvgUserRating(@PathVariable("movieId") String movieId) {
		return service.findAvgUserRating(movieId);
	}
	
	//FIND BY TYPE
	@RequestMapping(method = RequestMethod.GET, value = "type/{type}")
	public List<Movie> findByType(@PathVariable("type") String type) {
		return service.findByType(type);
	}
	
	//FIND BY YEAR
	@RequestMapping(method = RequestMethod.GET, value = "year/{year}")
	public List<Movie> findByYear(@PathVariable("year") Year year) {
		return service.findByYear(year);
	}
	
	//FIND BY GENRE
	@RequestMapping(method = RequestMethod.GET, value = "genre/{genre}")
	public List<Movie> findByGenre(@PathVariable("genre") String genre) {
		return service.findByGenre(genre);
	}
	
	//SORT BY IMDB RATING
	@RequestMapping(method = RequestMethod.GET, value = "sort/imdbRating")
	public List<Movie> sortByImdbRating() {
		return service.sortByImdbRating();
	}
	
	//SORT BY YEAR
	@RequestMapping(method = RequestMethod.GET, value = "sort/year")
	public List<Movie> sortByYear() {
		return service.sortByYear();
	}
	
	//SORT BY IMDB VOTES
	@RequestMapping(method = RequestMethod.GET, value = "sort/imdbVotes")
	public List<Movie> sortByImdbVotes() {
		return service.sortByImdbVotes();
	}

}

