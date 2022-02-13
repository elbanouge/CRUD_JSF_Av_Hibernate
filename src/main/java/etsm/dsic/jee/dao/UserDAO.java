package etsm.dsic.jee.dao;

import etsm.dsic.jee.model.User;
import java.util.List;

public interface UserDAO {

	public List<User> findAll();

	public User getUserById(Integer idUser);

	public void saveUser(User user) throws Exception;

	public void updateUser(User user);

	public void deleteUser(Integer id);
}
