 package io.spandana.movieflix_api.service;

import java.util.List;

import io.spandana.movieflix_api.entity.Comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.spandana.movieflix_api.exception.BadRequestException;
import io.spandana.movieflix_api.exception.EntityNotFoundException;
import io.spandana.movieflix_api.repository.CommentRepository;

@Service
public class CommentServiceImpl implements CommentService{

	@Autowired
	private CommentRepository repository;
	
	// FIND ALL COMMENTS FOR A MOVIE
	@Override
	@Transactional(readOnly = true)
	public List<Comment> findAll(String movieId) {
		
		Comment comment = (Comment) repository.findAll(movieId);
		if (comment == null) {
			throw new BadRequestException("No comments");
		}
		return (List<Comment>) comment;
	}

	//FIND COMMENT BY COMMENT ID
	@Override
	@Transactional(readOnly = true)
	public Comment findCommentById(String commentId) {
	
		Comment existing = (Comment) repository.findCommentById(commentId);
		if (existing == null) {
			throw new EntityNotFoundException("Comment not found");
		}
		
		return existing;
	}

	//CREATE COMMENT
	@Override
	@Transactional
	public Comment create(Comment comment) {
		
		return repository.create(comment);
	}

	//UPDATE COMMENT
	@Override
	@Transactional
	public Comment update(String commentId, Comment comment) {
		
		Comment existing = (Comment) repository.findCommentById(commentId);
		if (existing == null) {
			throw new EntityNotFoundException("Comment not found");
		}
		
		return repository.update(comment);
	}

	//DELETE COMMENT
	@Override
	@Transactional
	public void delete(String commentId) {
		
		Comment existing = (Comment) repository.findCommentById(commentId);
		if (existing == null) {
			throw new EntityNotFoundException("Comment not found");
		}
		
		repository.delete(existing);
	}

}
