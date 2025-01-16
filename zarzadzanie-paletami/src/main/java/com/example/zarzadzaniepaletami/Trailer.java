package com.example.zarzadzaniepaletami;

public class Trailer {
    private String name;
    private float length;
    private float width;
    private float height;
    private float weight;

    public Trailer(){};

    public Trailer(String name, float length, float width, float height, float weight){
        this.name = name;
        this.length = length;
        this.width = width;
        this.height = height;
        this.weight = weight;
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

    public float getWeight(){
        return this.weight;
    }
}
