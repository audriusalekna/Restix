package com.example.audrius.restix.objects;

/**
 * Created by audrius on 14/12/16.
 */

public class Restourant {
    private String title;
    private double rating;
    private String adress;
    private float lat;
    private float lng;
    private double kilom;
    private String imgUrl;

    public String getCat() {
        return cat;
    }

    private String cat;

    public Restourant(String title, double rating, String adress, float lat, float lng, String imgUrl, String cat) {
        this.title = title;
        this.rating = rating;
        this.adress = adress;
        this.lat = lat;
        this.lng = lng;
        this.imgUrl = imgUrl;
        this.cat = cat;
    }
    public String getImgUrl(){return imgUrl;}

    public String getTitle() {
        return title;
    }

    public double getRating() {
        return rating;
    }

    public String getAdress() {
        return adress;
    }

    public float getLat() {
        return lat;
    }

    public float getLng() {
        return lng;
    }

    public double getKilom() {
        return kilom;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public void setLng(float lng) {
        this.lng = lng;
    }

    public void setKilom(double kilom) {
        this.kilom = kilom;
    }
}
