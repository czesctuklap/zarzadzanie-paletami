package com.example.zarzadzaniepaletami;

public class Trailer {
    private String name;
    private float length;
    private float width;
    private float height;
    private float maxLoad;
    public Trailer(String name, float length, float width, float height, float maxLoad){
        this.name = name;
        this.length = length;
        this.width = width;
        this.height = height;
        this.maxLoad = maxLoad;
    }

    public String getName(){
        return this.name;
    }

    public float getLength(){
        return this.length;
    }

    public float getWidth(){
        return this.width;
    }

    public float getHeight(){
        return this.height;
    }

    public float getMaxLoad(){
        return this.maxLoad;
    }

    //@Override
    //public String toString() {
    //    return this.name;
    //}

}
