package org.example.controllers;

import org.example.database.CabManager;
import org.example.database.TripsManager;
import org.example.model.Cab;
import org.example.model.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CabsController {
    @Autowired
    private CabManager cabsManager;
    @Autowired
    private TripsManager tripsManager;

    public CabsController(CabManager cabsManager, TripsManager tripsManager) {
        this.cabsManager = cabsManager;
        this.tripsManager = tripsManager;
    }

    @RequestMapping(value = "/register/cab", method = RequestMethod.POST)
    public ResponseEntity registerCab(final String cabId, final String driverName) {
        cabsManager.createCab(new Cab(cabId, driverName));
        return ResponseEntity.ok("");
    }

    @RequestMapping(value = "/update/cab/location", method = RequestMethod.POST)
    public ResponseEntity updateCabLocation(final String cabId, final Double newX, final Double newY) {
        cabsManager.updateCabLocation(cabId, new Location(newX, newY));
        return ResponseEntity.ok("");
    }

    @RequestMapping(value = "update/cab/availability", method = RequestMethod.POST)
    public ResponseEntity updateCabAvailability(final String cabId, final Boolean newAvailability) {
        cabsManager.updateCabAvailability(cabId, newAvailability);
        return ResponseEntity.ok("");
    }

    @RequestMapping(value = "/update/cab/end/trip", method = RequestMethod.POST)
    public ResponseEntity endTrip(final String cabId) {
        tripsManager.endTrip(cabsManager.getCab(cabId));
        return ResponseEntity.ok("");
    }
}
