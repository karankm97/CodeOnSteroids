package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.dispatcher.ExternalButtonDispatcher;

@AllArgsConstructor
@Getter
public class ExternalButton {
    private Direction buttonDirection;
    private Floor floor;
    private ExternalButtonDispatcher dispatcher;
    //external button dispatcher create

    public void onButtonPress() {
        //send to dispatcher
        dispatcher.dispatch(floor.getBuilding(), floor, buttonDirection);
    }
}
