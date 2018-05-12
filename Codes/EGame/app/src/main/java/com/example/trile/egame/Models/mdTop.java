package com.example.trile.egame.Models;

/**
 * Created by TRILE on 06/04/2018.
 */

public class mdTop {
    private String imgUser;
    private String nameUser;
    private String coreUser;



    public mdTop() {
        //
    }

    public mdTop(String imgUser, String nameUser, String coreUser) {
        this.imgUser = imgUser;
        this.nameUser = nameUser;
        this.coreUser = coreUser;
    }

    public String getImgUser() {
        return imgUser;
    }

    public void setImgUser(String imgUser) {
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
