package trainning.hibernate.entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="CINEMA_ROOM_DETAIL",schema = "movietheaterdb")
public class CinemaRoomDetail {

    @Id @GeneratedValue
    @Column(name="CINEMA_ROOM_DETAIL_ID")
    private int roomDetailId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CINEMA_ROOM_ID")
    private CinemaRoom room;

    @Column(name="ROOM_RATE")
    private int roomRate;

    @Column(name="ACTIVE_DATE")
    @Temporal(TemporalType.DATE)
    private Date activeDate;

    @Column(name = "ROOM_DESCRIPTION")
    private String roomDescription;



    public CinemaRoom getDetailRoomId() {
        return room;
    }

    public void setDetailRoomId(CinemaRoom room) {
        this.room = room;
    }

    public CinemaRoomDetail() {
    }

    public int getRoomDetailId() {
        return roomDetailId;
    }

    public void setRoomDetailId(int roomDetailId) {
        this.roomDetailId = roomDetailId;
    }

    public int getRoomRate() {
        return roomRate;
    }

    public void setRoomRate(int roomRate) {
        this.roomRate = roomRate;
    }

    public Date getActiveDate() {
        return activeDate;
    }

    public void setActiveDate(Date activeDate) {
        this.activeDate = activeDate;
    }

    public String getRoomDescription() {
        return roomDescription;
    }

    public void setRoomDescription(String roomDescription) {
        this.roomDescription = roomDescription;
    }

    public CinemaRoomDetail(CinemaRoom room, int roomRate, Date activeDate, String roomDescription) {
        this.room = room;
        this.roomRate = roomRate;
        this.activeDate = activeDate;
        this.roomDescription = roomDescription;
    }

    @Override
    public String toString() {
        return "CinemaRoomDetail{" +
                "roomDetailId=" + roomDetailId +
                ", room=" + room +
                ", roomRate=" + roomRate +
                ", activeDate=" + activeDate +
                ", roomDescription='" + roomDescription + '\'' +
                '}';
    }
}
