package io.spandana.movieflix_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.spandana.movieflix_api.entity.Comment;
import io.spandana.movieflix_api.service.CommentService;

@RestController
@RequestMapping(value = "comments")
public class CommentController {

	@Autowired
	private CommentService service;
	
	//FIND ALL COMMENTS FOR A MOVIE
	@RequestMapping(method = RequestMethod.GET, value = "{movieId}")
	public Comment findAll(@PathVariable("movieId") String movieId) {
		return (Comment) service.findAll(movieId);
	}
	
	//FIND COMMENT BY COMMENT ID
	@RequestMapping(method = RequestMethod.GET, value = "{commentId}")
	public Comment findCommentById(@PathVariable("commentId") String commentId) {
		return service.findCommentById(commentId);
	}
	
	//CREATE
	@RequestMapping(method = RequestMethod.POST)
	public Comment create(@RequestBody Comment comment) {
		return (Comment) service.create(comment);
	}
	
	//UPDATE
	@RequestMapping(method = RequestMethod.PUT, value = "{commentId}")
	public Comment update(@PathVariable("commentId") String commentId, @RequestBody Comment comment) {
		return service.update(commentId, comment);
	}
	
	//DELETE
	@RequestMapping(method = RequestMethod.DELETE, value = "{commentId}")
	public void delete(@PathVariable("commentId") String commentId) {
		service.delete(commentId);
	}
}
