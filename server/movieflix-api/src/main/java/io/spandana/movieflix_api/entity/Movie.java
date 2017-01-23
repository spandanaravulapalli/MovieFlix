package io.spandana.movieflix_api.entity;

import java.time.Year;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Movie {
	
	@Id
	private String id;
	private String title;
	private Year year;
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
	
	public Movie() {
		this.id = UUID.randomUUID().toString();
	}

}
