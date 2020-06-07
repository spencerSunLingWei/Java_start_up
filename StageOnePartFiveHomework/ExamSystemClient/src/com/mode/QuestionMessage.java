package com.mode;

import java.io.Serializable;

public class QuestionMessage implements Serializable {

    private static final long serialVersionUID = 2941800238900317608L;
    private String type;
    private Question question;

    public QuestionMessage() {
    }

    public QuestionMessage(String type, Question question) {
        this.type = type;
        this.question = question;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "QuestionMessage{" +
                "type='" + type + '\'' +
                ", question=" + question +
                '}';
    }
}
