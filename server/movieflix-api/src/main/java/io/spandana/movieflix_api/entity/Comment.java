package io.spandana.movieflix_api.entity;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import org.eclipse.persistence.annotations.ReadOnly;

@Entity
@NamedQueries({ 
	@NamedQuery(name = "Comment.findAll", query = "SELECT c FROM Comment c"),
	@NamedQuery(name = "Comment.findCommentById", query = "SELECT c FROM Comment c WHERE c.commentId=:pCommentId")
	})

public class Comment {
	
	//movie associated with this rental
    @ManyToOne
    @JoinColumn(name="movieId", nullable = false,insertable=false, updatable=false)
    private Movie movie; 

    //client associated with this rental
    @ManyToOne
    @JoinColumn(name="userId", nullable = false,insertable=false, updatable=false)
    private User user; 
    
    
	@Id
	private String commentId;
	
	private String userId;
	private String comment;
	private Timestamp timestamp;
	
	public Comment() {
		this.commentId = UUID.randomUUID().toString();
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getCommentId() {
		return commentId;
	}

	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	
}
