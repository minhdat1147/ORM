package trainning.hibernate.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import trainning.hibernate.entities.CinemaRoom;
import trainning.hibernate.entities.CinemaRoomDetail;
import trainning.hibernate.utils.HibernateUtils;

import java.sql.Date;

public class RoomDetailDaoImpl extends EntityDaoImpl implements RoomDetailDao {
    @Override
    public CinemaRoomDetail get(int id){
        Session session = null;
        try{
            session = HibernateUtils.getSessionFactory().openSession();
            return (CinemaRoomDetail)  session.get(CinemaRoomDetail.class, id);
        }catch (HibernateException e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return null;
    }
    @Override
    public Integer addRoomDetail(CinemaRoom room, int roomRate, Date activeDate, String roomDescription) {
        Session session = null;
        Transaction tx = null;
        Integer cinemaRoomDetailID = null;
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            tx = session.beginTransaction();
            CinemaRoomDetail cinemaRoomDetail = new CinemaRoomDetail(room, roomRate,activeDate,roomDescription);
            cinemaRoomDetailID = (Integer) session.save(cinemaRoomDetail);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return cinemaRoomDetailID;
    }
}
