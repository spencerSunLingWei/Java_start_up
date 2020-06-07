package com.mode;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class User implements Serializable {

    private static final long serialVersionUID = 3626098050863082322L;
    private String username;
    private String password;
    private HashMap<String, ArrayList<Integer>> score = new HashMap<>();

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.score = new HashMap<>();
    }

    public HashMap<String, ArrayList<Integer>> getScore() {
        return score;
    }

    public void setScore(HashMap<String, ArrayList<Integer>> score) {
        this.score = score;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
