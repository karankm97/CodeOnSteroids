package org.example.exception;

import org.example.model.ParkingLot;

public class ParkingLotException extends RuntimeException {
    public ParkingLotException() {

    }

    public ParkingLotException(String msg) {
        super(msg);
    }
}
