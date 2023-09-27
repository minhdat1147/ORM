package trainning.hibernate.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import trainning.hibernate.entities.CinemaRoom;
import trainning.hibernate.entities.Seat;
import trainning.hibernate.utils.HibernateUtils;

public class SeatDaoImpl extends EntityDaoImpl implements SeatDao {
    @Override
    public Seat get(int id){
        Session session = null;
        try{
            session = HibernateUtils.getSessionFactory().openSession();
            return (Seat)  session.get(Seat.class, id);
        }catch (HibernateException e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return null;
    }
    public Integer addSeat(int room, String seatColumn, int seatRow, String seatStatus, String seatType) {
        Session session = null;
        Transaction tx = null;
        Integer seatId = null;
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            tx = session.beginTransaction();
            Seat seat = new Seat(room, seatColumn, seatRow,seatStatus,seatType);
            seatId = (Integer) session.save(seat);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return seatId;
    }
}
