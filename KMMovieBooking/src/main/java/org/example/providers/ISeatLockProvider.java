package org.example.providers;

import org.example.model.Seat;
import org.example.model.Show;

import java.util.List;

public interface ISeatLockProvider {
    public void lockSeats(Show show, List<Seat> seats, String user);
    public void unlockSeats(Show show, List<Seat> seats, String user);

    public List<Seat> getLockedSeats(Show show);

    boolean validateLock(Show show, Seat seats, String user);
}
