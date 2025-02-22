package com.example.zarzadzaniepaletami;

import java.util.ArrayList;
import java.util.List;

public class Pallet {
    private float length;
    private float width;
    private float height;
    private float weight;
    private int quantity;

    public Pallet(float length, float width, float height, float weight, int quantity){
        this.weight = weight;
        this.length = length;
        this.width = width;
        this.height = height;
        this.quantity = quantity;
    }

    public List<Pallet> getRotations() {
        List<Pallet> rotations = new ArrayList<>();
        rotations.add(new Pallet(width, length, height, weight, quantity));
        rotations.add(new Pallet(length, width, height, weight, quantity));
        return rotations;
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

    //@Override
    //public String toString() {
    //    return this.length+"x"+this.height+", "+this.quantity;
    //}
}
