package etsm.dsic.jee.services;

import java.util.List;
import etsm.dsic.jee.dao.ContactDAO;
import etsm.dsic.jee.dao.ContactDAOImpl;
import etsm.dsic.jee.model.Contact;

public class ContactServiceImpl implements ContactService {

	private ContactDAO ContactDao = new ContactDAOImpl();

	@Override
	public List<Contact> findAll() {
		return ContactDao.findAll();
	}

	@Override
	public Contact getContactById(Integer idContact) {
		return ContactDao.getContactById(idContact);
	}

	@Override
	public void saveContact(Contact Contact) throws Exception {
		ContactDao.saveContact(Contact);
	}

	@Override
	public void updateContact(Contact Contact) {
		ContactDao.updateContact(Contact);
	}

	@Override
	public void deleteContact(Integer id) {
		ContactDao.deleteContact(id);
	}

}
