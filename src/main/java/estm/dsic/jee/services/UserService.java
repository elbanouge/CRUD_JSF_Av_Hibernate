package estm.dsic.jee.services;

import estm.dsic.jee.model.User;

public interface UserService {

	public User CheckUser(User user);

	public User getUserByName(String name);

	public String saveUser(User user);

}
