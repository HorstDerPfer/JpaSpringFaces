package de.fmi.framework.core.dao;

import java.sql.SQLException;

import org.springframework.dao.DataAccessException;

import de.fmi.framework.core.model.User;

public interface JpaSpringDao {

	User checkUser(String userName) throws DataAccessException, SQLException;

	User validateUser(String userName, String password)
			throws DataAccessException, SQLException;

	void addUser(User obj) throws DataAccessException;
}
