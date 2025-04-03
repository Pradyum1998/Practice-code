package com.example.demo.service;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    private int userId;
    private String userName;
    private String city;

    /*
  mappedBy = "user" ---> specifies that relationship is mapped by the user field in the usermobile entity
  cascade = CascadeType.ALL ---> any operation on user (e.g. save, delete) will cascade to usermobile records
  orphanRemoval = true ----> if a usermobile record is removed from the usermoble list, it will be deleted from the db
  fetch = FetchType.LAZY -----> loads usermobile record only when accessed
    * */
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private List<UserMobiles> userMobiles;

    public List<UserMobiles> getUserMobiles() {
        return userMobiles;
    }

    public void setUserMobiles(List<UserMobiles> userMobiles) {
        this.userMobiles = userMobiles;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", city='" + city + '\'' +
                ", userMobiles=" + userMobiles +
                '}';
    }
}
