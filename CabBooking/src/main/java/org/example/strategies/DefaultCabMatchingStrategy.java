package org.example.strategies;

import lombok.NonNull;
import org.example.model.Cab;
import org.example.model.Location;
import org.example.model.Rider;

import java.util.List;

public class DefaultCabMatchingStrategy implements CabMatchingStrategy {
    @Override
    public Cab matchCabToRider(
            @NonNull Rider ride,
            @NonNull List<Cab> candidateCabs,
            @NonNull Location fromLocation,
            @NonNull Location toLocation) {
        if(candidateCabs.isEmpty()) {
            return null;
        } else {
            return candidateCabs.get(0);
        }
    }
}
