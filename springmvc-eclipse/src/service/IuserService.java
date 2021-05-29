package service;

import java.util.List;

import model.User;

public interface IuserService {

	User findbyId(String username);

	void insert(User user);

	 void delete(String username);

	void update(User user);

	void insert2(User user);

	List<User> findbyname(String username);

}
