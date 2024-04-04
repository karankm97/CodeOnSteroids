package org.example.strategy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.model.Building;
import org.example.model.Direction;
import org.example.model.Elevator;
import org.example.model.Floor;

import java.util.List;

@AllArgsConstructor
public class OddEvenDispatchStrategy implements IDispatchStrategy {
    public Elevator selectElevator(Building building, Floor floor, Direction direction) {
        List<Elevator> elevators = building.getElevators();
        if(elevators.size() == 1) return elevators.get(0);

        Elevator elevator = elevators.get(0);
        Integer minDis = Math.abs(elevator.getCurFloor() - floor.getFloorNo());

        for(Elevator el : elevators) {
            if (Math.abs(el.getCurFloor() - floor.getFloorNo()) < minDis) {
                //TODO: add direction filter too
                elevator = el;
                minDis = Math.abs(el.getCurFloor() - floor.getFloorNo());
            }
        }

        return elevator;
    }
}
