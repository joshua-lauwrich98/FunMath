package com.ancovy.funmath.other;

/**
 * Created by DarKnight98 on 4/28/2017.
 */

public class Friend {

    private String photo, status, time, username;

    public Friend() {
    }

    public Friend(String photo, String status, String time, String username) {
        this.photo = photo;
        this.status = status;
        this.time = time;
        this.username = username;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
