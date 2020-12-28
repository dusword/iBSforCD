package com.lxjtest.entity;

public class User {
    String USER_ID;
    String USER_NAME;
    String USER_PASSWORD;

    public User( String USER_NAME, String USER_PASSWORD) {
//        this.USER_ID = USER_ID;
        this.USER_NAME = USER_NAME;
        this.USER_PASSWORD = USER_PASSWORD;
    }

    public String getUSER_ID() {
        return USER_ID;
    }

    public void setUSER_ID(String USER_ID) {
        this.USER_ID = USER_ID;
    }

    public String getUSER_NAME() {
        return USER_NAME;
    }

    public void setUSER_NAME(String USER_NAME) {
        this.USER_NAME = USER_NAME;
    }

    public String getUSER_PASSWORD() {
        return USER_PASSWORD;
    }

    public void setUSER_PASSWORD(String USER_PASSWORD) {
        this.USER_PASSWORD = USER_PASSWORD;
    }
}
