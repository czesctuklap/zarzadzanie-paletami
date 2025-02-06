package com.example.zarzadzaniepaletami;

import java.util.ArrayList;
import java.util.List;

public class TrailerManager {
    private List<Trailer> trailers;

    public TrailerManager() {
        trailers = new ArrayList<>();
        trailers.add(new Trailer("Blaszak", 3000, 1500, 1700, 800));
        trailers.add(new Trailer("Firanka - Bus", 4200, 2100, 2200, 1200));
        trailers.add(new Trailer("Kontener", 6000, 2450, 2400, 3000));
        trailers.add(new Trailer("Firanka - Solówka", 7200, 2450, 2500, 3000));
        trailers.add(new Trailer("Plandeka", 13600, 2450, 2750, 24000)); //90m3
        trailers.add(new Trailer("Furgon", 13620, 2460, 2700,22000)); //90m3
        trailers.add(new Trailer("Standard", 13620, 2450, 2670,24000)); //91m3
        trailers.add(new Trailer("Mega", 13600, 2450, 2900,24000)); //100m3
        // w milimetrach i kilogramach                                                             objetosc
    }

    public List<Trailer> getTrailers() {
        return trailers;
    }
}
