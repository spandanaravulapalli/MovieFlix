package io.spandana.movieflix_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import io.spandana.movieflix_api.entity.User;
import io.spandana.movieflix_api.service.UserService;

@RestController
@RequestMapping(value = "users")
public class UserController {

	@Autowired
	private UserService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<User> findAll() {
		return service.findAll();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "{email}")
	public User findByEmail(@PathVariable("email") String email) {
		return service.findByEmail(email);
	}

	@RequestMapping(method = RequestMethod.POST)
	public User create(@RequestBody User user) {
		return service.create(user);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "{email}")
	public User update(@PathVariable("email") String email, @RequestBody User user) {
		return service.update(email, user);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "{email}")
	public void delete(@PathVariable("email") String email) {
		service.delete(email);
	}
}
