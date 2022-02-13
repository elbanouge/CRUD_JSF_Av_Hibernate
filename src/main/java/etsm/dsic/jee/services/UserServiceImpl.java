package etsm.dsic.jee.services;

import java.util.List;

import etsm.dsic.jee.dao.UserDAO;
import etsm.dsic.jee.dao.UserDAOImpl;
import etsm.dsic.jee.model.User;

public class UserServiceImpl implements UserService {

	private UserDAO UserDao = new UserDAOImpl();

	@Override
	public List<User> findAll() {
		return UserDao.findAll();
	}

	@Override
	public User getUserById(Integer idUser) {
		return UserDao.getUserById(idUser);
	}

	@Override
	public void saveUser(User User) throws Exception {
		UserDao.saveUser(User);
	}

	@Override
	public void updateUser(User User) {
		UserDao.updateUser(User);
	}

	@Override
	public void deleteUser(Integer id) {
		UserDao.deleteUser(id);
	}

}
