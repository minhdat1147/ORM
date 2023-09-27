package trainning.hibernate.entities;

import javax.persistence.*;

@Entity
@Table(name = "SEAT", schema = " movietheaterdb")
public class Seat {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SEAT_ID")
    private int seatID;

    @ManyToOne
    @JoinColumn(name = "CINEMA_ROOM_ID")
    private int room;

    @Column(name = "SEAT_COLUMN", columnDefinition = "varchar(255)",nullable = false)
    private String seatColumn;

    @Column(name = "SEAT_ROW", nullable = false)
    private int seatRow;

    @Column(name="SEAT_STATUS", columnDefinition = "varchar(255)",nullable = false)
    private String seatStatus;

    @Column(name = "SEAT_TYPE", columnDefinition = "varchar(255)",nullable = false)
    private String seatType;

    public Seat() {
    }

    public int getSeatID() {
        return seatID;
    }

    public void setSeatID(int seatID) {
        this.seatID = seatID;
    }

    public String getSeatColumn() {
        return seatColumn;
    }

    public void setSeatColumn(String seatColumn) {
        this.seatColumn = seatColumn;
    }

    public int getSeatRow() {
        return seatRow;
    }

    public void setSeatRow(int seatRow) {
        this.seatRow = seatRow;
    }

    public String getSeatStatus() {
        return seatStatus;
    }

    public void setSeatStatus(String seatStatus) {
        this.seatStatus = seatStatus;
    }

    public String getSeatType() {
        return seatType;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public Seat(int room, String seatColumn, int seatRow, String seatStatus, String seatType) {
        this.room = room;
        this.seatColumn = seatColumn;
        this.seatRow = seatRow;
        this.seatStatus = seatStatus;
        this.seatType = seatType;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "seatID=" + seatID +
                ", room=" + room +
                ", seatColumn='" + seatColumn + '\'' +
                ", seatRow=" + seatRow +
                ", seatStatus='" + seatStatus + '\'' +
                ", seatType='" + seatType + '\'' +
                '}';
    }
}
