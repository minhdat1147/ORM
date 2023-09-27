package trainning.hibernate.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import trainning.hibernate.entities.CinemaRoom;
import trainning.hibernate.entities.Seat;
import trainning.hibernate.utils.HibernateUtils;

public class RoomDaoImpl extends  EntityDaoImpl  implements RoomDao{
    @Override
    public CinemaRoom get(int id){
        Session session = null;
        try{
            session = HibernateUtils.getSessionFactory().openSession();
            return (CinemaRoom)  session.get(CinemaRoom.class, id);

        }catch (HibernateException e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return null;
    }
    @Override
    public Integer addRoom(String name, int seatQuantity) {
        Session session = null;
        Transaction tx = null;
        Integer cinemaRoomID = null;
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            tx = session.beginTransaction();
            CinemaRoom cinemaRoom = new CinemaRoom(name, seatQuantity);
            cinemaRoomID = (Integer) session.save(cinemaRoom);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return cinemaRoomID;
    }
}
