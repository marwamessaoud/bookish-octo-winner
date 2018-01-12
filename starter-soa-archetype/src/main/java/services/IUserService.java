package services;

import java.util.List;

import domain.User;

public interface IUserService {
	boolean addUser(User user);

	List<User> findAllUsers();
}
