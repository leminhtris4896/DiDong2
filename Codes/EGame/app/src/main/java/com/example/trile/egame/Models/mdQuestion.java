package com.example.trile.egame.Models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class mdQuestion implements Parcelable{
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

    protected mdQuestion(Parcel in) {
        imgQuestion = in.readString();
        RequestQuestion = in.readString();
        arrayAnswer = in.createStringArrayList();
        answer = in.readString();
    }

    public static final Creator<mdQuestion> CREATOR = new Creator<mdQuestion>() {
        @Override
        public mdQuestion createFromParcel(Parcel in) {
            return new mdQuestion(in);
        }

        @Override
        public mdQuestion[] newArray(int size) {
            return new mdQuestion[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(imgQuestion);
        parcel.writeString(RequestQuestion);
        parcel.writeStringList(arrayAnswer);
        parcel.writeString(answer);
    }
}
