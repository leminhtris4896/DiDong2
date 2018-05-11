package com.example.trile.egame.Models;

/**
 * Created by TRILE on 08/05/2018.
 */

public class mdUsers {
    private String mail;
    private String pass;
    private String name;
    private int point;
    private String img;

    public mdUsers(String mail, String pass, String name, int point, String img) {
        this.mail = mail;
        this.pass = pass;
        this.name = name;
        this.point = point;
        this.img = img;
    }

    public mdUsers() {
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
