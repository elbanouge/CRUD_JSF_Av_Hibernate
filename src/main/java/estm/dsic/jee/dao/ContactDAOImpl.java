package estm.dsic.jee.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import estm.dsic.jee.model.Contact;
import estm.dsic.jee.util.HibernateUtil;

public class ContactDAOImpl implements ContactDAO {

	@Override
	public void saveContact(Contact contact) throws Exception {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the contact object
			session.save(contact);
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
	public List<Contact> findAll(int idUs, String value) {
		// TODO Auto-generated method stub
		Transaction transaction = null;
		List<Contact> listOfContact = null;
		Query<Contact> query = null;

		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an contact object
			if (value != null) {
				System.out.println("OK" + value);
				query = session.createQuery(
						"select c from Contact c where c.name like :name or c.adresse like :adresse or c.email like :email or c.tel like :tel group by c.id_contact having c.id_us=:id_us");
				query.setParameter("name", "%" + value + "%");
				query.setParameter("adresse", "%" + value + "%");
				query.setParameter("email", "%" + value + "%");
				query.setParameter("tel", "%" + value + "%");
				query.setParameter("id_us", idUs);

			} else {
				query = session.createQuery("from Contact c where c.id_us=:udUs");
				query.setParameter("udUs", idUs);
			}

			listOfContact = query.getResultList();

			for (Contact contact : listOfContact) {
				System.out.println("****" + contact);
			}
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
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an contact object
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
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the contact object
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
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			// Delete a contact object
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
