package estm.dsic.jee.services;

import java.util.List;

import estm.dsic.jee.model.Contact;

public interface ContactService {

	public List<Contact> findAll(int idUs, String value);

	public Contact getContactById(Integer idContact);

	public void saveContact(Contact contact) throws Exception;

	public void updateContact(Contact contact);

	public void deleteContact(Integer id);

}
