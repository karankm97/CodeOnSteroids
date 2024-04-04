package org.example.strategy;

import org.example.model.Building;
import org.example.model.Direction;
import org.example.model.Elevator;
import org.example.model.Floor;

public interface IDispatchStrategy {
    public Elevator selectElevator(Building building, Floor floor, Direction direction);
}
