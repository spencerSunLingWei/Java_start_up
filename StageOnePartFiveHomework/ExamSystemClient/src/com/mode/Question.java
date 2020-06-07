package com.mode;

import java.io.Serializable;

public class Question implements Serializable {

    private static final long serialVersionUID = 5785021849344414536L;
    private String problemDescription;
    private String correctAnswer;
    private String answerA;
    private String answerB;
    private String answerC;
    private String answerD;
    private String problemType;

    public Question() {
    }

    public Question(String problemDescription, String correctAnswer, String answerA, String answerB, String answerC, String answerD, String problemType) {
        this.problemDescription = problemDescription;
        this.correctAnswer = correctAnswer;
        this.answerA = answerA;
        this.answerB = answerB;
        this.answerC = answerC;
        this.answerD = answerD;
        this.problemType = problemType;
    }

    public String getProblemDescription() {
        return problemDescription;
    }

    public void setProblemDescription(String problemDescription) {
        this.problemDescription = problemDescription;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getAnswerA() {
        return answerA;
    }

    public void setAnswerA(String answerA) {
        this.answerA = answerA;
    }

    public String getAnswerB() {
        return answerB;
    }

    public void setAnswerB(String answerB) {
        this.answerB = answerB;
    }

    public String getAnswerC() {
        return answerC;
    }

    public void setAnswerC(String answerC) {
        this.answerC = answerC;
    }

    public String getAnswerD() {
        return answerD;
    }

    public void setAnswerD(String answerD) {
        this.answerD = answerD;
    }

    public String getProblemType() {
        return problemType;
    }

    public void setProblemType(String problemType) {
        this.problemType = problemType;
    }

    @Override
    public String toString() {
        return "Question{" +
                "\n\tproblemDescription='" + problemDescription +
                "\n\t\t\tA: " + answerA +
                "\n\t\t\tB: " + answerB +
                "\n\t\t\tC: " + answerC +
                "\n\t\t\tD: " + answerD +
                "\n}";
    }
}
