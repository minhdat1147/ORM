package trainning.hibernate.dao;

import trainning.hibernate.entities.CinemaRoom;
import trainning.hibernate.entities.CinemaRoomDetail;

import java.sql.Date;

public interface RoomDetailDao {
    public CinemaRoomDetail get(int id);
    Integer addRoomDetail(CinemaRoom room, int roomRate, Date activeDate, String roomDescription);
}
