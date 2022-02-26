package estm.dsic.jee.controller;

import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import estm.dsic.jee.model.User;
import estm.dsic.jee.services.UserServiceImpl;

@ManagedBean(name = "ManagersUsers", eager = true)
@RequestScoped
public class ManagersUsers {
	private User user;
	private UserServiceImpl userServiceImpl;

	public ManagersUsers() {
		super();
		// TODO Auto-generated constructor stub
		user = new User();
		userServiceImpl = new UserServiceImpl();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	private Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

	public String login() {
		User us = userServiceImpl.CheckUser(user);

		if (us != null) {
			sessionMap.put("userInfo", us);
			System.out.println(us.getPassword() + us.getEmail() + us.getName() + us.getId_user());
			return "/contactsList.xhtml?faces-redirect=true";

		} else {
			FacesMessage messageID = new FacesMessage("Login ou mot depasse incorrect !!!!");
			FacesContext.getCurrentInstance().addMessage(null, messageID);
			return null;
		}

	}

	public String add() throws Exception {
		userServiceImpl.saveUser(user);
		return "/login.xhtml?faces-redirect=true";
	}

}
