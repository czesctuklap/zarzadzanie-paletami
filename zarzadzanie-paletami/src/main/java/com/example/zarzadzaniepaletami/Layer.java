package com.example.zarzadzaniepaletami;

import java.util.ArrayList;
import java.util.List;

public class Layer {
    private float width;
    private float depth;
    private float height;
    private float usedWidth;
    private List<Pallet> placedPallets;

    public Layer(float width, float depth, float height) {
        this.width = width;
        this.depth = depth;
        this.height = height;
        this.usedWidth = 0;
        this.placedPallets = new ArrayList<>();
    }

    public float getHeight() {
        return this.height;
    }

    public boolean placeBox(Pallet pallet) {
        for (Pallet rotatedPallet : pallet.getRotations()) {
            if (rotatedPallet.getWidth() <= (width - usedWidth) && rotatedPallet.getLength() <= depth) {
                placedPallets.add(new Pallet(
                        rotatedPallet.getLength(),
                        rotatedPallet.getWidth(),
                        rotatedPallet.getHeight(),
                        rotatedPallet.getWeight(),
                        1
                ));
                usedWidth += rotatedPallet.getWidth();
                return true;
            }
        }
        return false;
    }

    public List<Pallet> getPlacedPallets() {
        return placedPallets;
    }
}
