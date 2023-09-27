package trainning.hibernate.dao;

import trainning.hibernate.entities.CinemaRoom;

public interface RoomDao {
    CinemaRoom get(int id);
    Integer addRoom(String name, int seatQuantity);
}
