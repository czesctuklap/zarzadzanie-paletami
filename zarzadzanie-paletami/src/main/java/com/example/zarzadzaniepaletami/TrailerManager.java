package com.example.zarzadzaniepaletami;

import java.util.ArrayList;
import java.util.List;

public class TrailerManager {
    private List<Trailer> trailers;

    public TrailerManager() {
        trailers = new ArrayList<>();
        // w centymetrach i kilogramach                                                             objetosc
        trailers.add(new Trailer("Furgon", 1362, 246, 270,22000)); //90m3
        trailers.add(new Trailer("Standard", 1362, 245, 267,24000)); //91m3
        trailers.add(new Trailer("Mega", 1360, 245, 290,24000)); //100m3
    }

    public List<Trailer> getTrailers() {
        return trailers;
    }
}
