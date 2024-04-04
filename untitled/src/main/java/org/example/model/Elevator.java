package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class Elevator {
    private final String id;
    private Integer curFloor;
    private final Display display;
    private Direction direction;
    private Status status;
    List<InternalButton> buttons;

    public void pressButton(Integer floor) {
        //dispatch to internal dispatcher deom
    }
}
