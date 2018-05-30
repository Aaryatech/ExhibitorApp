package com.ats.exhibitorapp.model;

public class FeedbackQuestionModel {

    private int id;
    private String question;

    public FeedbackQuestionModel(int id, String question) {
        this.id = id;
        this.question = question;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "FeedbackQuestionModel{" +
                "id=" + id +
                ", question='" + question + '\'' +
                '}';
    }
}
