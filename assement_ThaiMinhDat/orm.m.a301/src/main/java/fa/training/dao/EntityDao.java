package fa.training.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import fa.training.utils.HibernateUtils;

import java.util.List;

public class EntityDao<T> {

	private static SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

	/*
	 * Get
	 */
	public T getById(T object, int Id) {
		Session session = sessionFactory.openSession();

		try {
			T object2 = (T) session.get(object.getClass(), Id);
			if (object2 != null) {
				return object2;
			} else {
				System.err.println("Not Found");
				return null;
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	/*
	 * get all
	 */
	public List<T> getAll(String entityClassName) {
		Session session = sessionFactory.openSession();
		String hql = "from " + entityClassName;

		try {
			Query query = session.createQuery(hql);
			return (List<T>) query.list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (session != null) {
				session.close();
			}
		}
		return null;
	}

	/*
	 * Create
	 */
	public void save(T object) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();

			// ★ Insert into Table
			session.save(object);

			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	/*
	 * Delete
	 */
	public void delete(T object) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();

			// Delete it
			session.delete(object);

			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	/*
	 * Print
	 */
	public void print(List<T> objects) {
		for (T object : objects) {
			System.err.println(object.toString());
		}
	}

}
