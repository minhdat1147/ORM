package fa.training.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

	public static SessionFactory getSessionFactory() {
		try {
			Configuration configuration = new Configuration();
			configuration.configure();
			return configuration.buildSessionFactory();
		} catch (Exception e) {
			System.err.println("Failed to create sessionFactory object.");
			e.printStackTrace();
		}
		return null;
	}

}
