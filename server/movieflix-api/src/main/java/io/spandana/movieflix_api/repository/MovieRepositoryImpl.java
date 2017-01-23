package io.spandana.movieflix_api.repository;

import java.time.Year;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.spandana.movieflix_api.entity.Movie;
import io.spandana.movieflix_api.entity.User;

@Repository
public class MovieRepositoryImpl implements MovieRepository{

	@PersistenceContext
	private EntityManager em;

	@Override
	public Movie create(Movie movie) {
		
		em.persist(movie);
		return movie;
	}

	@Override
	public Movie update(Movie movie) {
		
		return em.merge(movie);
	}

	@Override
	public void delete(Movie movie) {
		
		em.remove(movie);
	}

	@Override
	public Movie giveRating(String movieID, int rating) {
		
		return null;
	}

	@Override
	public List<Movie> findAll() {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findAll", Movie.class);
		return query.getResultList();
		
	}

	@Override
	public Movie findMovieDetails(String movieId) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findMovieDetails", Movie.class);
		query.setParameter("pMovieId", movieId);
		return query.getSingleResult();
		
	}

	@Override
	public List<Movie> findTopMovies() {
		
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findTopMovies", Movie.class);
		query.setParameter("pType", "movie");
		return (List<Movie>) query.getResultList();
	}

	@Override
	public List<Movie> findTopSeries() {
		
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findTopSeries", Movie.class);
		query.setParameter("pType", "series");
		return (List<Movie>) query.getResultList();
	}

	@Override
	public Movie findAvgUserRating(String movieId) {
		
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findAvgUserRating", Movie.class);
		query.setParameter("pMovieId", movieId);
		return (Movie) query.getResultList();
		
	}

	@Override
	public Movie findByType(String type) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findByType", Movie.class);
		query.setParameter("pType", type);
		return (Movie) query.getResultList();

	}

	@Override
	public Movie findByYear(Year year) {
		
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findByYear", Movie.class);
		query.setParameter("pYear", year);
		return (Movie) query.getResultList();
	}

	@Override
	public Movie findByGenre(String genre) {
		
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findByGenre", Movie.class);
		query.setParameter("pGenre", genre);
		return (Movie) query.getResultList();
	}

	@Override
	public List<Movie> sortByImdbRating() {
		
		TypedQuery<Movie> query = em.createNamedQuery("Movie.sortByImdbRating", Movie.class);
		return (List<Movie>) query.getResultList();
	}

	@Override
	public List<Movie> sortByYear() {
		
		TypedQuery<Movie> query = em.createNamedQuery("Movie.sortByYear", Movie.class);
		return (List<Movie>) query.getResultList();
		
	}

	@Override
	public List<Movie> sortByImdbVotes() {
		
		TypedQuery<Movie> query = em.createNamedQuery("Movie.sortByImdbVotes", Movie.class);
		return (List<Movie>) query.getResultList();
	}
}
