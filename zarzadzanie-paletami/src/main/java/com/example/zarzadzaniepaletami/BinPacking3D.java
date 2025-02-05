package com.example.zarzadzaniepaletami;

import java.util.*;

public class BinPacking3D {

    public static boolean calculate(List<Pallet> cargo, Trailer trailer) {
        List<DimensionGroup> groupedPallets = groupPallets(cargo);
        //System.out.println(groupedPallets);

        int toLoad = 0;
        for (Pallet p : cargo) {
            toLoad += p.getQuantity();
        }

        float rowHalf = trailer.getWidth() / 2;

        for (Pallet p : cargo) {
            if (p.getLength() > rowHalf && p.getWidth() > rowHalf) {
                return false;
            }
        }
        // czy paleta jest za duża

        groupedPallets.sort((g1, g2) -> {
            float dp1 = computeDepthPerPallet(g1, rowHalf);
            float dp2 = computeDepthPerPallet(g2, rowHalf);
            return Float.compare(dp2, dp1);
        });
        // sortowanie grup po głębokości malejąco

        for (int row = 1; row <= 2; row++) {
            // dwa rzędy
            float currentDepth = 0;
            while (currentDepth < trailer.getLength() && toLoad > 0) {
                boolean placed = false;
                for (DimensionGroup group : groupedPallets) {
                    if (group.getPallets().isEmpty()) {
                        continue;
                    }

                    String[] dims = group.getDimension().split("x");
                    float longer = Float.parseFloat(dims[0]);
                    float shorter = Float.parseFloat(dims[1]);
                    float depthPerPallet = (longer <= rowHalf) ? shorter : longer;
                    // głębokość dla grupy

                    if (currentDepth + depthPerPallet > trailer.getLength()) {
                        continue;
                    }

                    float currentHeight = 0;
                    int palletsPlaced = 0;
                    Iterator<Pallet> iterator = group.getPallets().iterator();
                    while (iterator.hasNext()) {
                        Pallet p = iterator.next();
                        if (currentHeight + p.getHeight() <= trailer.getHeight()) {
                            currentHeight += p.getHeight();
                            palletsPlaced++;
                            iterator.remove();
                            toLoad--;
                            if (toLoad == 0) {
                                return true;
                            }
                        } else {
                            break;
                        }
                    }
                    // układanie w wysokość

                    if (palletsPlaced > 0) {
                        currentDepth += depthPerPallet;
                        placed = true;
                        break;
                    }
                }
                if (!placed) {
                    break; // nie można umieścić więcej w tym rzędzie
                }
            }
        }

        return toLoad == 0;
    }

    private static float computeDepthPerPallet(DimensionGroup group, float rowHalf) {
        String[] dims = group.getDimension().split("x");
        float longer = Float.parseFloat(dims[0]);
        float shorter = Float.parseFloat(dims[1]);
        return (longer <= rowHalf) ? shorter : longer;
    }

    public static List<DimensionGroup> groupPallets(List<Pallet> cargo) {
        List<DimensionGroup> groupedPallets = new ArrayList<>();

        for (Pallet p : cargo) {
            List<Pallet> palletsToAdd = new ArrayList<>();
            for (int i = 0; i < p.getQuantity(); i++) {
                palletsToAdd.add(new Pallet(p.getLength(), p.getWidth(), p.getHeight(), p.getWeight(), 1));
            }

            for (Pallet pallet : palletsToAdd) {
                String dimension = getDimensions(pallet);

                DimensionGroup existingGroup = null;
                for (DimensionGroup group : groupedPallets) {
                    if (group.getDimension().equals(dimension)) {
                        existingGroup = group;
                        break;
                    }
                }

                if (existingGroup == null) {
                    existingGroup = new DimensionGroup(dimension, new ArrayList<>());
                    groupedPallets.add(existingGroup);
                }

                existingGroup.addPallet(pallet);
            }
        }

        return groupedPallets;
    }

    public static String getDimensions(Pallet pallet) {
        float longerSide = Math.max(pallet.getLength(), pallet.getWidth());
        float shorterSide = Math.min(pallet.getLength(), pallet.getWidth());
        return longerSide + "x" + shorterSide;
    }

    public static class DimensionGroup {
        private String dimension;
        private List<Pallet> pallets;

        public DimensionGroup(String dimension, List<Pallet> pallets) {
            this.dimension = dimension;
            this.pallets = pallets;
        }

        public String getDimension() {
            return dimension;
        }

        public List<Pallet> getPallets() {
            return pallets;
        }

        public void addPallet(Pallet pallet) {
            this.pallets.add(pallet);
        }

        @Override
        public String toString() {
            return dimension + ", " + pallets;
        }

    }
}