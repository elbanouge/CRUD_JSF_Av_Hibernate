package etsm.dsic.jee.services;

import java.util.List;
import etsm.dsic.jee.model.Contact;

public interface ContactService {

	public List<Contact> findAll();

	public Contact getContactById(Integer idContact);

	public void saveContact(Contact Contact) throws Exception;

	public void updateContact(Contact Contact);

	public void deleteContact(Integer id);

}
