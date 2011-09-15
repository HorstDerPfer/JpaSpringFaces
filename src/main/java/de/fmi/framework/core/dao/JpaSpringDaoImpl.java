package de.fmi.framework.core.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.jpa.JpaCallback;
import org.springframework.orm.jpa.support.JpaDaoSupport;

import de.fmi.framework.core.model.User;

public class JpaSpringDaoImpl extends JpaDaoSupport implements JpaSpringDao {

	@Override
	public User checkUser(String userName) throws DataAccessException,
			SQLException {
		User obj = null;

		List objs = getJpaTemplate().executeFind(new JpaCallback<User>() {
			@Override
			public User doInJpa(EntityManager em) throws PersistenceException {
				// criteria.add(Expression.eq("userName", strUserName));
				return null;
			}
		});

		if ((objs != null) && (objs.size() > 0)) {
			obj = (User) objs.get(0);
		}
		return obj;
	}

	@Override
	public User validateUser(String userName, String password)
			throws DataAccessException, SQLException {

		User obj = null;

		List objs = getJpaTemplate().executeFind(new JpaCallback<User>() {
			@Override
			public User doInJpa(EntityManager arg0) throws PersistenceException {
				// criteria.add(Expression.eq("userName", strUserName));
				// criteria.add(Expression.eq("userPassword", password));
				return null;
			}
		});

		if ((objs != null) && (objs.size() > 0)) {
			obj = (User) objs.get(0);
		}

		return obj;
	}

	@Override
	public void addUser(User obj) throws DataAccessException {
		getJpaTemplate().persist(obj);
	}

}
