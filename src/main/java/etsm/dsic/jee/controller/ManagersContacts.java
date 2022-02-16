package etsm.dsic.jee.controller;

import etsm.dsic.jee.model.Contact;
import etsm.dsic.jee.services.ContactServiceImpl;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "ManagersContacts", eager = true)
@RequestScoped
public class ManagersContacts {

	private Contact contact;
	private ContactServiceImpl ContactServiceImpl;

	private Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

	public ManagersContacts() {
		super();
		// TODO Auto-generated constructor stub
		setContact(new Contact());
		ContactServiceImpl = new ContactServiceImpl();
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public String getById() {
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
		Integer id = Integer.parseInt(params.get("action").toString());
		Contact con = ContactServiceImpl.getContactById(id);

		ManagersContacts managersContacts = new ManagersContacts();
		managersContacts.contact.setId_contact(con.getId_contact());
		managersContacts.contact.setName(con.getName());
		managersContacts.contact.setAdresse(con.getAdresse());
		managersContacts.contact.setEmail(con.getEmail());
		managersContacts.contact.setTel(con.getTel());
		sessionMap.put("editContact", managersContacts);

		return "/editContact.xhtml?faces-redirect=true";
	}

	public String add() throws Exception {
		ContactServiceImpl.saveContact(contact);
		return "/contactsList.xhtml?faces-redirect=true";
	}

	public List<Contact> getAll() {
		return ContactServiceImpl.findAll();
	}

	public String update() {

		ContactServiceImpl.updateContact(contact);
		return "/contactsList.xhtml?faces-redirect=true";
	}

	public void delete() {
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
		Integer id = Integer.parseInt(params.get("action").toString());

		ContactServiceImpl.deleteContact(id);
	}

}
