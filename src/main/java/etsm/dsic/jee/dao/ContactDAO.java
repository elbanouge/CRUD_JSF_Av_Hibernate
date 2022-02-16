package etsm.dsic.jee.dao;

import etsm.dsic.jee.model.Contact;
import java.util.List;

public interface ContactDAO {

	public List<Contact> findAll();

	public Contact getContactById(Integer idContact);

	public void saveContact(Contact Contact) throws Exception;

	public void updateContact(Contact Contact);

	public void deleteContact(Integer id);
}
