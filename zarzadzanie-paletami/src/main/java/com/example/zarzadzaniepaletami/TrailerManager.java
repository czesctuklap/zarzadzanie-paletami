package com.example.zarzadzaniepaletami;

import java.util.ArrayList;
import java.util.List;

public class TrailerManager {
    private List<Trailer> trailers;

    public TrailerManager() {
        trailers = new ArrayList<>();
        // w milimetrach i kilogramach                                                             objetosc
        trailers.add(new Trailer("Furgon", 13620, 2460, 2700,22000)); //90m3
        trailers.add(new Trailer("Standard", 13620, 2450, 2670,24000)); //91m3
        trailers.add(new Trailer("Mega", 13600, 2450, 2900,24000)); //100m3
    }

    public List<Trailer> getTrailers() {
        return trailers;
    }
}
