package estm.dsic.jee.services;

import java.util.List;
import estm.dsic.jee.dao.ContactDAO;
import estm.dsic.jee.dao.ContactDAOImpl;
import estm.dsic.jee.model.Contact;

public class ContactServiceImpl implements ContactService {

	private ContactDAO ContactDao = new ContactDAOImpl();

	@Override
	public List<Contact> findAll(int idUs, String value) {
		return ContactDao.findAll(idUs, value);
	}

	@Override
	public Contact getContactById(Integer idContact) {
		return ContactDao.getContactById(idContact);
	}

	@Override
	public void saveContact(Contact contact) throws Exception {
		ContactDao.saveContact(contact);
	}

	@Override
	public void updateContact(Contact contact) {
		ContactDao.updateContact(contact);
	}

	@Override
	public void deleteContact(Integer id) {
		ContactDao.deleteContact(id);
	}

}
