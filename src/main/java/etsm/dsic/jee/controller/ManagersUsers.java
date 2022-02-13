package etsm.dsic.jee.controller;

import etsm.dsic.jee.model.User;
import etsm.dsic.jee.services.UserServiceImpl;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "ManagersUsers", eager = true)
@RequestScoped
public class ManagersUsers {

	private User user;
	private UserServiceImpl userServiceImpl;

	private Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

	public ManagersUsers() {
		super();
		// TODO Auto-generated constructor stub
		user = new User();
		userServiceImpl = new UserServiceImpl();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User User) {
		this.user = User;
	}

	public String getById() {
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
		Integer id = Integer.parseInt(params.get("action").toString());
		User user = userServiceImpl.getUserById(id);

		ManagersUsers managersUsers = new ManagersUsers();
		managersUsers.user.setId(user.getId());
		managersUsers.user.setName(user.getName());
		managersUsers.user.setEmail(user.getEmail());
		managersUsers.user.setCountry(user.getCountry());
		sessionMap.put("edituser", managersUsers);

		return "/edit.xhtml?faces-redirect=true";
	}

	public void add() throws Exception {
		userServiceImpl.saveUser(user);
	}

	public List<User> getAll() {
		return userServiceImpl.findAll();
	}

	public String update() {
		userServiceImpl.updateUser(user);

		return "/index.xhtml?faces-redirect=true";
	}

	public void delete() {
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
		Integer id = Integer.parseInt(params.get("action").toString());

		userServiceImpl.deleteUser(id);
	}
}
