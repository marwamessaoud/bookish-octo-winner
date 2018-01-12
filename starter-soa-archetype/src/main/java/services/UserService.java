package services;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import domain.User;

@WebService
@Stateless
@Local
public class UserService implements IUserService {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public boolean addUser(User user) {
		boolean b = false;
		try {
			entityManager.persist(user);
			b = true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return b;
	}

	@Override
	public List<User> findAllUsers() {
		return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();

	}

}
