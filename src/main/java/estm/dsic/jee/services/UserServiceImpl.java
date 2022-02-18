package estm.dsic.jee.services;

import estm.dsic.jee.dao.UserDAO;
import estm.dsic.jee.dao.UserDAOImpl;
import estm.dsic.jee.model.User;

public class UserServiceImpl implements UserService {

	private UserDAO userDao = new UserDAOImpl();

	@Override
	public User CheckUser(User user) {
		// TODO Auto-generated method stub
		return userDao.CheckUser(user);
	}

	@Override
	public User getUserByName(String name) {
		// TODO Auto-generated method stub
		return userDao.getUserByName(name);
	}

	@Override
	public String saveUser(User user) {
		// TODO Auto-generated method stub
		return userDao.saveUser(user);
	}

}
