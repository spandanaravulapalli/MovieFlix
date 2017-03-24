package io.spandana.movieflix_api.service;

import java.util.List;

import io.spandana.movieflix_api.entity.User;

public interface UserService {

	public List<User> findAll();

	public User findByEmail(String email);

	public User create(User user);

	public User update(String email, User user);

	public void delete(String email);
}
