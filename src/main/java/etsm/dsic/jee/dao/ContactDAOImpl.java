package etsm.dsic.jee.dao;

import etsm.dsic.jee.model.Contact;
import etsm.dsic.jee.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ContactDAOImpl implements ContactDAO {

	@Override
	public void saveContact(Contact Contact) throws Exception {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.save(Contact);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Contact> findAll() {
		// TODO Auto-generated method stub
		Transaction transaction = null;
		List<Contact> listOfContact = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an Contact object

			listOfContact = session.createQuery("from Contact").getResultList();

			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return listOfContact;
	}

	@Override
	public Contact getContactById(Integer idContact) {
		// TODO Auto-generated method stub
		Transaction transaction = null;
		Contact Contact = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an Contact object
			Contact = session.get(Contact.class, idContact);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return Contact;
	}

	@Override
	public void updateContact(Contact Contact) {
		// TODO Auto-generated method stub
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.update(Contact);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	@Override
	public void deleteContact(Integer id) {
		// TODO Auto-generated method stub
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			// Delete a Contact object
			Contact Contact = session.get(Contact.class, id);
			System.out.println(Contact);
			if (Contact != null) {
				session.delete(Contact);
				System.out.println("Contact is deleted");
			}

			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

}
