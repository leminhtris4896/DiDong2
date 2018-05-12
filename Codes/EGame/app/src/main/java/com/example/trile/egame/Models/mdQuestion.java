package com.example.trile.egame.Models;

import java.util.ArrayList;

public class mdQuestion {
    private String imgQuestion;
    private String RequestQuestion;
    private ArrayList<String> arrayAnswer;
    private String answer;

    public mdQuestion() {
    }

    public mdQuestion(String imgQuestion, String requestQuestion, ArrayList<String> arrayAnswer, String answer) {
        this.imgQuestion = imgQuestion;
        RequestQuestion = requestQuestion;
        this.arrayAnswer = arrayAnswer;
        this.answer = answer;
    }

    public String getImgQuestion() {
        return imgQuestion;
    }

    public void setImgQuestion(String imgQuestion) {
        this.imgQuestion = imgQuestion;
    }

    public String getRequestQuestion() {
        return RequestQuestion;
    }

    public void setRequestQuestion(String requestQuestion) {
        RequestQuestion = requestQuestion;
    }

    public ArrayList<String> getArrayAnswer() {
        return arrayAnswer;
    }

    public void setArrayAnswer(ArrayList<String> arrayAnswer) {
        this.arrayAnswer = arrayAnswer;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
