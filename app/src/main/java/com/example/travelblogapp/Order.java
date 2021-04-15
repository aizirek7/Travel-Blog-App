package com.example.travelblogapp;

import android.widget.ImageView;

public class Order {
    private int goodImage;
    private String goodTitle;
    private String goodDescription;
    private String goodPrice;
    private String goodCskrf;


    public Order(int goodImage, String goodTitle, String goodDescription, String goodPrice, String goodCskrf) {
        this.goodTitle = goodTitle;
        this.goodDescription = goodDescription;
        this.goodPrice = goodPrice;
        this.goodCskrf = goodCskrf;
        this.goodImage = goodImage;
    }


    public String getGoodTitle() {
        return goodTitle;
    }

    public String getGoodDescription() {
        return goodDescription;
    }

    public String getGoodPrice() {
        return goodPrice;
    }

    public String getGoodCskrf() {
        return goodCskrf;
    }

    public int getGoodImage() {
        return goodImage;
    }
}
