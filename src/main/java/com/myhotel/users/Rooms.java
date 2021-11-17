package com.myhotel.users;

import javax.persistence.*;

@Entity
@Table (name = "rooms")
public class Rooms {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String roomnumber;

    @Column(nullable = false)
    private String free;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String availble;

    @Column(nullable = false)
    private String des;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAvailble() {
        return availble;
    }

    public void setAvailble(String availble) {
        this.availble = availble;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getRoomnumber() {
        return roomnumber;
    }

    public void setRoomnumber(String roomnumber) {
        this.roomnumber = roomnumber;
    }

    public String getFree() {
        return free;
    }

    public void setFree(String free) {
        this.free = free;
    }

    @Override
    public String toString() {
        return "Rooms{" +
                "id=" + id +
                ", roomnumber='" + roomnumber + '\'' +
                ", free='" + free + '\'' +
                ", type='" + type + '\'' +
                ", availble='" + availble + '\'' +
                ", des='" + des + '\'' +
                '}';
    }
}
