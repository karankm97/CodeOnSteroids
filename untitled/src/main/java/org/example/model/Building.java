package org.example.model;

import lombok.Getter;

import java.util.List;

@Getter
public class Building {
    List<Floor> floors;
    List<Elevator> elevators;
    public Building(List<Floor> floors, List<Elevator> elevators) {
        this.floors = floors;
        this.elevators = elevators;
    }
}
