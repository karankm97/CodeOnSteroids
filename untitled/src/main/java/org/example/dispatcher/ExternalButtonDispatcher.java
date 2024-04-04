package org.example.dispatcher;

import lombok.AllArgsConstructor;
import org.example.controller.ElevatorController;
import org.example.model.Building;
import org.example.model.Direction;
import org.example.model.Elevator;
import org.example.model.Floor;
import org.example.strategy.IDispatchStrategy;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
public class ExternalButtonDispatcher {
    private IDispatchStrategy strategy;
    private Map<String, ElevatorController> controllerMap;

    public void addController(ElevatorController controller) {
        controllerMap.put(controller.getElevator().getId(), controller);
    }

    public void dispatch(Building building, Floor floor, Direction direction) {
        Elevator el = strategy.selectElevator(building, floor, direction);
        controllerMap.get(el.getId()).acceptExternalRequest(floor, direction);
    }
}
