package org.example.strategies;

import org.example.model.Cab;
import org.example.model.Location;
import org.example.model.Rider;

import java.util.List;

public interface CabMatchingStrategy {
    Cab matchCabToRider(Rider rider, List<Cab> candidateCabs, Location fromPoint, Location toPoint);
}
