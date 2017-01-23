package io.spandana.movieflix_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.spandana.movieflix_api.exception.EntityNotFoundException;
import io.spandana.movieflix_api.exception.BadRequestException;
import io.spandana.movieflix_api.entity.User;
import io.spandana.movieflix_api.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository repository;
	
	@Override
	@Transactional(readOnly = true)
	public List<User> findAll() {
		
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public User findByEmail(String email) {
		User user = repository.findByEmail(email);
		if (user == null) {
			throw new EntityNotFoundException("User not found");
		}
		return user;
	}

	@Override
	@Transactional
	public User create(User user) {
		User existing = repository.findByEmail(user.getEmail());
		if (existing != null) {
			throw new BadRequestException("User with this email already exists");
		}
		return repository.create(user);
	}

	@Override
	@Transactional
	public User update(String email, User user) {
		User existing = repository.findByEmail(email);
		if (existing == null) {
			throw new EntityNotFoundException("User not found");
		}
		return repository.update(user);

	}

	@Override
	@Transactional
	public void delete(String email) {
		
		User existing = repository.findByEmail(email);
		if (existing == null) {
			throw new EntityNotFoundException("User not found");
		}
		repository.delete(existing);
	}

}
