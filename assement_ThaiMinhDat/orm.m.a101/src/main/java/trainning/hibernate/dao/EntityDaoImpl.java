package trainning.hibernate.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import trainning.hibernate.utils.HibernateUtils;

import java.util.List;

public class EntityDaoImpl implements EntityDao {


    @Override
    public Object getById(Object object, int id) {
        Session session = null;
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            return (Object) session.get(object.getClass(), id);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    public List<Object> getAll (String entityClassName){
        Session session = null;
        String hql = " from "+entityClassName;
        try{
            session = HibernateUtils.getSessionFactory().openSession();
            Query query = session.createQuery(hql);
            return (List<Object>) query.list();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(session !=null){
                session.close();
            }
        }
        return null;
    }

    @Override
    public void delete(Object object) {
        Session session = null;
        Transaction tx = null;
        try{
            session = HibernateUtils.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.delete(object);
            tx.commit();

        }catch (HibernateException e){
            if(tx != null){
                tx.rollback();
            }
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    @Override
    public void showInformation(List objects) {
        for (Object object: objects
        ) {
            System.out.println(object.toString());
        }
    }
}
