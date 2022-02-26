package estm.dsic.jee.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import estm.dsic.jee.model.User;
import estm.dsic.jee.util.HibernateUtil;

public class UserDAOImpl implements UserDAO {

	@Override
	public User CheckUser(User user) {
		// TODO Auto-generated method stub
		User us = this.getUserByName(user.getName());

		if (us != null && user.getName().equals(us.getName()) && user.getPassword().equals(us.getPassword())) {
			return us;
		} else {
			return null;
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public User getUserByName(String name) {
		// TODO Auto-generated method stub
		Transaction transaction = null;
		User user = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an user object
			Query<User> query = session.createQuery("from User where name=:name");
			query.setParameter("name", name);
			user = query.uniqueResult();
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public String saveUser(User user) {
		// TODO Auto-generated method stub
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the user object
			session.save(user);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return null;
	}

}
