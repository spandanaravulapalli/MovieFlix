package io.spandana.movieflix_api.service;

import java.util.List;

import io.spandana.movieflix_api.entity.Comment;


public interface CommentService {

	public List<Comment> findAll(String movieId);
	
	public Comment findCommentById(String commentId);

	public Comment create(Comment comment);

	public Comment update(String commentId, Comment comment);

	public void delete(String commentId);
}
