package de.fmi.framework.core.service;

import java.util.List;

import de.fmi.framework.core.model.User;

public interface UserService {

	List<User> findAllUsers();

	void save(User user);
}
