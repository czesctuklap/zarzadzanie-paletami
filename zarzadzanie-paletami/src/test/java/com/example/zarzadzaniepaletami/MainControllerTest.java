package com.example.zarzadzaniepaletami;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class MainControllerTest {

    @Test
    void testAddPallet() {
        List<Pallet> cargo = new ArrayList<>();
        cargo.add(new Pallet(100, 200, 150, 10, 1));

        assertEquals(1, cargo.size());
        Pallet addedPallet = cargo.get(0);
        assertEquals(100, addedPallet.getLength());
        assertEquals(200, addedPallet.getWidth());
        assertEquals(150, addedPallet.getHeight());
        assertEquals(10, addedPallet.getWeight());
        assertEquals(1, addedPallet.getQuantity());
    }

    @Test
    void testDeletePallet() {
        List<Pallet> cargo = new ArrayList<>();
        Pallet pallet = new Pallet(100, 200, 150, 10, 1);
        cargo.add(pallet);

        assertEquals(1, cargo.size());
        cargo.remove(pallet);
        assertEquals(0, cargo.size());
    }

    @Test
    void testCalculateTrailerWeightExceed() {
        List<Pallet> cargo = new ArrayList<>();
        cargo.add(new Pallet(100, 200, 150, 2000, 1));

        List<Trailer> trailers = new ArrayList<>();
        trailers.add(new Trailer("Test", 1000, 500,500,1500));

        float totalWeight = (float) cargo.stream()
                .mapToDouble(p -> p.getWeight() * p.getQuantity())
                .sum();

        float maxTrailerLoad = trailers.get(0).getMaxLoad();
        boolean fitsInWeight = totalWeight <= maxTrailerLoad;

        assertFalse(fitsInWeight);
    }

    @Test
    void testAddPalletWithInvalidData() {
        List<Pallet> cargo = new ArrayList<>();

        try {
            cargo.add(new Pallet(Float.parseFloat("abc"), 200, 150, 10, 1));
            //fail("wyjątek");
        } catch (NumberFormatException e) {
            System.out.println("wyjątek "+e);
        }

        assertEquals(0, cargo.size());
    }

}