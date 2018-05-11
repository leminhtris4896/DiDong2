package com.example.trile.egame.Models;

/**
 * Created by TRILE on 06/04/2018.
 */

public class mdTop {
    private int imgUser;
    private String nameUser;
    private String coreUser;

    public mdTop(int imgUser, String nameUser, String coreUser) {
        this.imgUser = imgUser;
        this.nameUser = nameUser;
        this.coreUser = coreUser;
    }

    public mdTop() {
        //
    }

    public int getImgUser() {
        return imgUser;
    }

    public void setImgUser(int imgUser) {
        this.imgUser = imgUser;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getCoreUser() {
        return coreUser;
    }

    public void setCoreUser(String coreUser) {
        this.coreUser = coreUser;
    }
}
