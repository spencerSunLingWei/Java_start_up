package com.mode;

import java.io.Serializable;
import java.util.ArrayList;

public class UserExamMessage implements Serializable {

    private static final long serialVersionUID = 4236347975825400713L;
    private String type;
    private User user;
    private String problemType;
    private int score;

    public UserExamMessage() {
    }

    public UserExamMessage(String type, User user, String problemType, int score) {
        this.type = type;
        this.user = user;
        this.problemType = problemType;
        this.score = score;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getProblemType() {
        return problemType;
    }

    public void setProblemType(String problemType) {
        this.problemType = problemType;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "UserExamMessage{" +
                "type='" + type + '\'' +
                ", user=" + user +
                ", problemType='" + problemType + '\'' +
                ", score=" + score +
                '}';
    }
}
