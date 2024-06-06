package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.exception.InvalidStateException;

import java.util.List;

@AllArgsConstructor
@Getter
public class Booking {
    private String id;
    private Show show;
    private String user;
    private List<Seat> seats;
    private BookingStatus status;

    public boolean isConfirmed() {
        return  this.status == BookingStatus.CONFIRMED;
    }

    public void confirmBooking() {
        if(! (status == BookingStatus.CREATED)) {
            throw new InvalidStateException();
        }
        status = BookingStatus.CONFIRMED;
    }

    public void expireBooking() {
        if(!(status == BookingStatus.CREATED)) {
            throw new InvalidStateException();
        }
        status = BookingStatus.EXPIRED;
    }
}
