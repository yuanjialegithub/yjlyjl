package com.example.myapplication;

public class ImageListArray {
    private String name;
    private int imageId;
    private int jiantou;
    private String title;

    public ImageListArray(String title,String name, int imageId,int name2){
        this.name = name;
        this.imageId = imageId;
        this.jiantou = name2;
        this.title = title;
    }
    public String getName() {
        return name;
    }
    public int getImageId() {
        return imageId;
    }
    public int getJiantou() {
        return jiantou;
    }
    public String getTitle(){
        return title;
    }
    }
