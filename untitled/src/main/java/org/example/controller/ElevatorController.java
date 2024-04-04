package org.example.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.model.Direction;
import org.example.model.Elevator;
import org.example.model.Floor;

@AllArgsConstructor
@Getter
public class ElevatorController {
    private final Elevator elevator;

    public void acceptExternalRequest(Floor floor, Direction direction) {

    }

    public void acceptInternalRequest(Floor floor) {

    }
}
