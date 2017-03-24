package io.spandana.movieflix_api.repository;

import java.util.List;

import io.spandana.movieflix_api.entity.Comment;

public interface CommentRepository {
	
public List<Comment> findAll(String movieId);
	
	public Comment findCommentById(String commentId);

	public Comment create(Comment comment);

	public Comment update(Comment comment);

	public void delete(Comment comment);

}
