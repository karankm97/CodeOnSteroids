package org.example.strategies;

import org.example.model.Location;

public class DefaultPricingStrategy implements PricingStrategy {
    public static Double KM_RATE = 10.0;
    public Double findPrice(Location fromLocation, Location toLocation) {
        return fromLocation.distance(toLocation) * KM_RATE;
    }
}
