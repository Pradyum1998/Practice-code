package com.example.demo.service;

import jakarta.persistence.*;

@Entity
public class UserMobiles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String mobileNumber;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserMobiles{" +
                "id=" + id +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", user=" + user +
                '}';
    }
}
