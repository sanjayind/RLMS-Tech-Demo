package com.rlms.model;

import android.graphics.drawable.Drawable;

public class SpinnerModel {

    String title = "";

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    Drawable image;

}
