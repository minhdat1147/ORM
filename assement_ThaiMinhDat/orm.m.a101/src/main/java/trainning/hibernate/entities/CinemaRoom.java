package trainning.hibernate.entities;


import org.hibernate.annotations.Proxy;

import javax.persistence.*;

@Proxy
@Entity
@Table(name = "CINEMA_ROOM", schema = "movietheaterdb")
public class CinemaRoom {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="CINEMA_ROOM_ID")
    private int id;

    @Column(name="CINEMA_ROOM_NAME", columnDefinition = "varchar(255)",nullable = false, unique = true)
    private  String name;

    @Column(name="SEAT_QUANTITY",nullable = false)
    private int seatQuantity;

    public CinemaRoom() {
    }

    public CinemaRoom(String name, int seatQuantity) {
        this.name = name;
        this.seatQuantity = seatQuantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSeatQuantity() {
        return seatQuantity;
    }

    public void setSeatQuantity(int seatQuantity) {
        this.seatQuantity = seatQuantity;
    }

    @Override
    public String toString() {
        return "CinemaRoom{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", seatQuantity=" + seatQuantity +
                '}';
    }
}
