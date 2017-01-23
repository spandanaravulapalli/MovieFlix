package io.spandana.movieflix_api.service;

import java.time.Year;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.spandana.movieflix_api.entity.Movie;
import io.spandana.movieflix_api.exception.BadRequestException;
import io.spandana.movieflix_api.exception.EntityNotFoundException;
import io.spandana.movieflix_api.repository.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService{

	@Autowired
	private MovieRepository repository;
	
	//CREATE
	@Override
	@Transactional
	public Movie create(Movie movie) {
		
		/*Movie existing = (Movie) repository.findMovieDetails(movie.getMovieId());
		if (existing != null) {
			throw new BadRequestException("Movie already exists in database");
		}*/
		return repository.create(movie);
	}

	//UPDATE
	@Override
	@Transactional
	public Movie update(String movieId, Movie movie) {
		
		Movie existing = (Movie) repository.findMovieDetails(movieId);
		if (existing == null) {
			throw new EntityNotFoundException("Movie not found");
		}
		return repository.update(movie);
	}

	//DELETE
	@Override
	@Transactional
	public void delete(String movieId) {
		
		Movie existing = (Movie) repository.findMovieDetails(movieId);
		if (existing == null) {
			throw new EntityNotFoundException("Movie not found");
		}
		repository.delete(existing);
	}

	//GIVE RATING
	@Override
	public Movie giveRating(String movieId, int rating) {
		
		Movie existing = (Movie) repository.findMovieDetails(movieId);
		if (existing == null) {
			throw new EntityNotFoundException("Movie not found");
		}
		return repository.giveRating(movieId, rating);
	}

	//FIND ALL
	@Override
	@Transactional(readOnly = true)
	public List<Movie> findAll() {
		
		return repository.findAll();
	}

	//FIND MOVIE DETAILS
	@Override
	@Transactional(readOnly = true)
	public Movie findMovieDetails(String movieId) {
	
		Movie existing = (Movie) repository.findMovieDetails(movieId);
		if (existing == null) {
			throw new EntityNotFoundException("Movie not found");
		}
		return repository.findMovieDetails(movieId);

	}

	//FIND TOP MOVIES
	@Override
	@Transactional(readOnly = true)
	public List<Movie> findTopMovies() {
		
		return repository.findTopMovies();
	}

	//FIND TOP SERIES
	@Override
	@Transactional(readOnly = true)
	public List<Movie> findTopSeries() {
		
		return repository.findTopSeries();
	}

	//FIND AVG USER RATING
	@Override
	@Transactional(readOnly = true)
	public Movie findAvgUserRating(String movieId) {
		
		return repository.findAvgUserRating(movieId);
	}

	//FIND BY TYPE
	@Override
	@Transactional(readOnly = true)
	public List<Movie> findByType(String type) {
		
		return (List<Movie>) repository.findByType(type);
	}

	// FIND BY YEAR
	@Override
	@Transactional(readOnly = true)
	public List<Movie> findByYear(Year year) {
		
		return (List<Movie>) repository.findByYear(year);
	}

	//FIND BY GENRE
	@Override
	@Transactional(readOnly = true)
	public List<Movie> findByGenre(String genre) {
		
		return (List<Movie>) repository.findByGenre(genre);
	}

	//SORT BY IMDB RATING
	@Override
	@Transactional(readOnly = true)
	public List<Movie> sortByImdbRating() {
		
		return repository.sortByImdbRating();
	}

	//SORT BY YEAR
	@Override
	@Transactional(readOnly = true)
	public List<Movie> sortByYear() {
		
		return repository.sortByYear();
	}

	//SORT BY IMDB VOTES
	@Override
	@Transactional(readOnly = true)
	public List<Movie> sortByImdbVotes() {
		
		return repository.sortByImdbVotes();
	}

}
