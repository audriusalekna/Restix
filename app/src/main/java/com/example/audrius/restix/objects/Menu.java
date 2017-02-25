package com.example.audrius.restix.objects;

/**
 * Created by audrius on 19/02/2017.
 */

public class Menu {
    private String title;
    private double price;
    private String ingredients;
    private String about;

    public Menu(String title, double price, String ingredients, String about) {
        this.title = title;
        this.price = price;
        this.ingredients = ingredients;
        this.about = about;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}
