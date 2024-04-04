package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.dispatcher.InternalButtonDispatcher;

@AllArgsConstructor
@Getter
public class InternalButton {
    private Elevator elevator;
    private Floor floor;
    private InternalButtonDispatcher dispatcher;
    //dispatcher
    public void onButtonPress() {
        dispatcher.dispatch(floor, elevator);
    }
}
