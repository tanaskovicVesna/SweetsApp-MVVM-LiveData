package com.example.mvvmlivedata.datamodels;

public class Sweets {
    private String mTitle;
    private int mImageResourceId;

    public Sweets(String title, int imageResourceId) {
        this.mTitle = title;
        this.mImageResourceId = imageResourceId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.mImageResourceId = imageResourceId;
    }
}
