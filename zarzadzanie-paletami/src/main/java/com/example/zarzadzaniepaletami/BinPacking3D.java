package com.example.zarzadzaniepaletami;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BinPacking3D {

    public static boolean calculate(List<Pallet> pallets, float containerWidth, float containerDepth, float containerHeight) {
        List<Layer> layers = new ArrayList<>();
        float remainingHeight = containerHeight;

        List<Pallet> unpackedPallets = new ArrayList<>();
        for (Pallet pallet : pallets) {
            for (int i = 0; i < pallet.getQuantity(); i++) {
                unpackedPallets.add(new Pallet(
                        pallet.getLength(),
                        pallet.getWidth(),
                        pallet.getHeight(),
                        pallet.getWeight(),
                        1
                ));
            }
        }

        unpackedPallets.sort(Comparator.comparingDouble(p -> -(p.getLength() * p.getWidth() * p.getHeight())));

        for (Pallet pallet : unpackedPallets) {
            boolean placed = false;

            for (Layer layer : layers) {
                if (layer.getHeight() >= pallet.getHeight() && layer.placeBox(pallet)) {
                    placed = true;
                    break;
                }
            }

            if (!placed) {
                if (remainingHeight >= pallet.getHeight()) {
                    Layer newLayer = new Layer(containerWidth, containerDepth, pallet.getHeight());
                    newLayer.placeBox(pallet);
                    layers.add(newLayer);
                    remainingHeight -= pallet.getHeight();
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}
