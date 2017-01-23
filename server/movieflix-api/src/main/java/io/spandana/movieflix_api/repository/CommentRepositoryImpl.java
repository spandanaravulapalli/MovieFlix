package io.spandana.movieflix_api.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import io.spandana.movieflix_api.entity.Comment;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;

@Repository
public class CommentRepositoryImpl implements CommentRepository{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Comment> findAll(String movieId) {
		
		TypedQuery<Comment> query = em.createNamedQuery("Comment.findAll", Comment.class);
		query.setParameter("pMovieId", movieId);
		return query.getResultList();
	}

	@Override
	public Comment findCommentById(String commentId) {
		
		TypedQuery<Comment> query = em.createNamedQuery("Comment.findCommentById", Comment.class);
		query.setParameter("pCommentId", commentId);
		return (Comment) query.getResultList();	
	}

	@Override
	public Comment create(Comment comment) {
		
		em.persist(comment);
		return comment;
	}

	@Override
	public Comment update(Comment comment) {
		
		return em.merge(comment);
	}

	@Override
	public void delete(Comment comment) {
		
		em.remove(comment);	
	}

}
