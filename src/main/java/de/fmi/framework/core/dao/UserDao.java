package de.fmi.framework.core.dao;

import java.util.List;

import de.fmi.framework.core.model.User;

public interface UserDao {

	List<User> findAll();

	void save(User user);
}
