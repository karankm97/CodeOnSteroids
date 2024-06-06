package org.example.service;

import org.example.exception.NotFoundException;
import org.example.exception.SeatNotUnavailableException;
import org.example.model.Booking;
import org.example.model.BookingStatus;
import org.example.model.Seat;
import org.example.model.Show;
import org.example.providers.ISeatLockProvider;

import java.awt.print.Book;
import java.util.*;
import java.util.stream.Collectors;

public class BookingService {
    private Map<String, Booking> bookings;
    private ISeatLockProvider seatLockProvider;

    public BookingService(ISeatLockProvider seatLockProvider) {
        this.seatLockProvider = seatLockProvider;
        this.bookings = new HashMap<>();
    }

    public Booking getBooking(String bookingId) {
        if(!bookings.containsKey(bookingId)) {
            throw new NotFoundException();
        }
        return bookings.get(bookingId);
    }

    public Booking createBooking(String user, Show show, List<Seat> seats) {
        if(isAnySeatAleadyBooked(show, seats)) {
            throw new SeatNotUnavailableException();
        }
        seatLockProvider.lockSeats(show, seats, user);
        String bookingId = UUID.randomUUID().toString();
        Booking newBooking = new Booking(bookingId, show, user, seats, BookingStatus.CREATED);
        bookings.put(bookingId, newBooking);
        return newBooking; //TODO: booking expiry
    }

    public List<Seat> getBookedSeats(Show show) {
        return getAllBookings(show).stream()
                .filter(Booking::isConfirmed)
                .map(Booking::getSeats)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    private List<Booking> getAllBookings(Show show) {
        List<Booking> bookingForShow = new ArrayList<>();
        for(Booking booking : bookings.values()) {
            if (booking.getShow().equals(show)) {
                bookingForShow.add(booking);
            }
        }
        return bookingForShow;
    }

    public void confirmBooking(Booking booking, String user) {
        for (Seat seat : booking.getSeats()) {
            if(!seatLockProvider.validateLock(booking.getShow(), seat, user)) {
                throw new SeatNotUnavailableException();
            }
        }

        booking.confirmBooking();
    }

    private boolean isAnySeatAleadyBooked(Show show, List<Seat> seats) {
        List<Seat> bookedSeats = getBookedSeats(show);
        for (Seat seat : seats) {
            if (bookedSeats.contains(seat)) {
                return  true;
            }
        }
        return  false;
    }
}
