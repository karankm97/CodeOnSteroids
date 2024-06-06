package org.example.service;

import org.example.model.Seat;
import org.example.model.Show;
import org.example.providers.ISeatLockProvider;

import java.util.List;

public class SeatAvailabilityService {
    private BookingService bookingService;
    private ISeatLockProvider seatLockProvider;

    public SeatAvailabilityService(BookingService bookingService, ISeatLockProvider seatLockProvider) {
        this.bookingService = bookingService;
        this.seatLockProvider = seatLockProvider;
    }

    public List<Seat> getAvailbleSeats(Show show) {
        List<Seat> allSeats = show.getScreen().getSeats();
        List<Seat> unavailableSeats = getUnavailableSeats(show);

        allSeats.removeAll(unavailableSeats);
        return  allSeats;
    }

    private List<Seat> getUnavailableSeats(Show show) {
        List<Seat> unavailableSeats = bookingService.getBookedSeats(show);
        unavailableSeats.addAll(seatLockProvider.getLockedSeats(show));
        return unavailableSeats;
    }
}
