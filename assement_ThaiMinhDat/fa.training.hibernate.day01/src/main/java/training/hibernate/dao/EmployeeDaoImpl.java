package training.hibernate.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import training.hibernate.model.Employee;
import training.hibernate.utils.HibernateUtils;

import java.util.Iterator;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {

    public Integer addEmployee(String firstName, String lastName) {
        Session session = null;
        Transaction tx = null;
        Integer employeeID = null;
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            tx = session.beginTransaction();
            Employee employee = new Employee(firstName, lastName);
            employeeID = (Integer) session.save(employee);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return employeeID;
    }

    @Override
    public void listEmployees() {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            tx = session.beginTransaction();
            List employees = session.createQuery("FROM Employee").list();
            for (Iterator iterator = employees.iterator(); iterator.hasNext();) {
                Employee employee = (Employee) iterator.next();
                System.out.print("ID: "+employee.getId());
                System.out.print("| First Name: " + employee.getFirstName());
                System.out.print("| Last Name: " + employee.getLastName());
                System.out.println();
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

}
