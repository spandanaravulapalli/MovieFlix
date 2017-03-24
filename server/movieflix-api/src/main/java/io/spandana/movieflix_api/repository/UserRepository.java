package io.spandana.movieflix_api.repository;

import java.util.List;

import io.spandana.movieflix_api.entity.User;

public interface UserRepository {

	public List<User> findAll();
	
	public User findByEmail(String email);

	public User create(User user);

	public User update(User user);

	public void delete(User user);
}
