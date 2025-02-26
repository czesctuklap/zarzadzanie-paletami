package com.example.zarzadzaniepaletami;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class BinPacking3DTest {

    @Test
    void testGroupingWithRotations() {
        List<Pallet> cargo = new ArrayList<>();
        cargo.add(new Pallet(1300, 1000, 1000, 0, 1));
        cargo.add(new Pallet(1000, 1300, 1000, 0, 1));

        List<BinPacking3D.DimensionGroup> groups = BinPacking3D.groupPallets(cargo);
        assertEquals(1, groups.size());
        assertEquals("1300.0x1000.0", groups.get(0).getDimension());
        assertEquals(2, groups.get(0).getPallets().size());
    }

    @Test
    void testVerticalStacking() {
        List<Pallet> cargo = new ArrayList<>();
        cargo.add(new Pallet(1000, 1000, 1000, 0, 3));
        Trailer trailer = new Trailer("Test", 3000, 2400, 2000, 1000);

        assertTrue(BinPacking3D.calculate(cargo, trailer));
    }

    @Test
    void testEdgeCaseDimensions() {
        Pallet edgePallet = new Pallet(1200, 1200, 1000, 0, 1);
        Trailer trailer = new Trailer("Test", 2400, 2400, 2000, 1000);

        assertTrue(BinPacking3D.calculate(List.of(edgePallet), trailer));
    }

    @Test
    void testMixedConfiguration() {
        List<Pallet> cargo = new ArrayList<>();
        cargo.add(new Pallet(1000, 1000, 2000, 0, 2));
        cargo.add(new Pallet(1500, 1000, 1000, 0, 3));

        Trailer trailer = new Trailer("Test", 3000, 2400, 2000, 1000);
        assertTrue(BinPacking3D.calculate(cargo, trailer));
    }

    @Test
    void testTwoRowsUsage() {
        List<Pallet> cargo = new ArrayList<>();
        cargo.add(new Pallet(1500, 1000, 1000, 0, 4));

        Trailer trailer = new Trailer("Test", 3000, 2400, 2000, 1000);
        assertTrue(BinPacking3D.calculate(cargo, trailer));
    }
}