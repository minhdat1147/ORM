package trainning.hibernate.dao;

import trainning.hibernate.entities.CinemaRoom;
import trainning.hibernate.entities.Seat;

public interface SeatDao {
    Seat get(int id);
    Integer addSeat(int room, String seatColumn, int seatRow, String seatStatus, String seatType);
}
