package etsm.dsic.jee.services;

import java.util.List;
import etsm.dsic.jee.model.User;

public interface UserService {

	public List<User> findAll();

	public User getUserById(Integer idUser);

	public void saveUser(User user) throws Exception;

	public void updateUser(User user);

	public void deleteUser(Integer id);

}
