package com.example.note.Model;

public class User {
    private String userID;
    private String userPassword;

    public User(){

    }

    public User(String userID, String userPassword) {
        this.userID = userID;
        this.userPassword = userPassword;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
