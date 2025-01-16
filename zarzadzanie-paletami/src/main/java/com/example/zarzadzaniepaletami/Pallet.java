package com.example.zarzadzaniepaletami;

public class Pallet {
    private float length;
    private float width;
    private float height;
    private float weight;
    private int quantity;

    public Pallet(){}

    public Pallet(float length, float width, float height, float weight, int quantity){
        this.weight = weight;
        this.length = length;
        this.width = width;
        this.height = height;
        this.quantity = quantity;
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

    public int getQuantity(){
        return this.quantity;
    }
}
