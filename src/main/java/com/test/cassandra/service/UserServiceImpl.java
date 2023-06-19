package com.test.cassandra.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.cassandra.entity.UserEntity;
import com.test.cassandra.model.User;
import com.test.cassandra.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private UserRepository repository;

	@Override
	public User createUser(User user) {
		UserEntity entity = modelMapper.map(user, UserEntity.class);
		repository.save(entity);
		return modelMapper.map(entity, User.class);
	}

	@Override
	public List<User> getAll() {

		return repository.findAll().stream().map(e -> modelMapper.map(e, User.class)).collect(Collectors.toList());
	}

	@Override
	public User getUserById(int id) {

		return modelMapper.map(repository.findById(id), User.class);
	}

	@Override
	public User updateUser(int id, User user) {
		UserEntity existingUser = repository.findById(id).get();
		existingUser.setName(user.getName());
		existingUser.setNickName(user.getNickName());
		existingUser.setEmail(user.getEmail());
		return modelMapper.map(repository.save(existingUser), User.class);

	}

	@Override
	public void deleteUser(int id) {

		repository.deleteById(id);

	}

	@Override
	public void deleteAllUsers() {
		repository.deleteAll();
	}
}
