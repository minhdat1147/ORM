package fa.training.dao;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;

import fa.training.entities.Departments;
import fa.training.utils.HibernateUtils;

public class DepartmentDaoImpl implements DepartmentDao {

	public boolean save(Departments department) throws Exception {
		Session session = null;
		Transaction transaction = null;

		try {
			session = HibernateUtils.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			Serializable result = session.save(department);

			transaction.commit();
			return (result != null);
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
}
