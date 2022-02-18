package estm.dsic.jee.dao;

import estm.dsic.jee.model.User;

public interface UserDAO {

	public User CheckUser(User user);

	public User getUserByName(String name);

	public String saveUser(User user);
}
