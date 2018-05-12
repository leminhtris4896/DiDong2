package com.example.trile.egame.Models;

/**
 * Created by TRILE on 08/05/2018.
 */

public class mdLearn {
    private String img;
    private String mp3;
    private String eng;
    private String write;
    private String viet;
    private String cau;

    private String type;



    public mdLearn() {
        //
    }

    public mdLearn(String img, String mp3, String eng, String write, String viet, String cau, String type) {
        this.img = img;
        this.mp3 = mp3;
        this.eng = eng;
        this.write = write;
        this.viet = viet;
        this.cau = cau;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getMp3() {
        return mp3;
    }

    public void setMp3(String mp3) {
        this.mp3 = mp3;
    }

    public String getEng() {
        return eng;
    }

    public void setEng(String eng) {
        this.eng = eng;
    }

    public String getWrite() {
        return write;
    }

    public void setWrite(String write) {
        this.write = write;
    }

    public String getViet() {
        return viet;
    }

    public void setViet(String viet) {
        this.viet = viet;
    }

    public String getCau() {
        return cau;
    }

    public void setCau(String cau) {
        this.cau = cau;
    }
}
