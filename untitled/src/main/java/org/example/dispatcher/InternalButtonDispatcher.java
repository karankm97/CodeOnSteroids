package org.example.dispatcher;

import org.example.controller.ElevatorController;
import org.example.model.Elevator;
import org.example.model.Floor;

import java.util.List;
import java.util.Map;

public class InternalButtonDispatcher {
    Map<String, ElevatorController> controllerMap;

    public void addController(ElevatorController controller) {
        controllerMap.put(controller.getElevator().getId(), controller);
    }

    public void dispatch(Floor floor, Elevator elevator) {
        //call controller of elevator with reques
        controllerMap.get(elevator.getId()).acceptInternalRequest(floor);
    }

}
