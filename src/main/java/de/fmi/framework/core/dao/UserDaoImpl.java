package de.fmi.framework.core.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import de.fmi.framework.core.model.User;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	@SuppressWarnings("unchecked")
	public List<User> findAll() {
		return em.createQuery("from User u").getResultList();
	}

	@Override
	public void save(User user) {
		em.persist(user);
	}

}
