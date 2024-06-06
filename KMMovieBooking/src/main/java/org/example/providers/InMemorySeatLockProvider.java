package org.example.providers;

import org.example.exception.SeatTempUnavailable;
import org.example.model.Seat;
import org.example.model.SeatLock;
import org.example.model.Show;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class InMemorySeatLockProvider implements ISeatLockProvider {
    Map<Show, Map<Seat, SeatLock>> lockMap;
    private Long timeout;

    public InMemorySeatLockProvider(Long timeout) {
        lockMap = new HashMap<>();
        this.timeout = timeout;
    }

    @Override
    synchronized public void lockSeats(Show show, List<Seat> seats, String user) {
        for (Seat seat : seats) {
            if(isSeatLocked(show, seat)) {
                throw new SeatTempUnavailable();
            }
        }

        for (Seat seat : seats) {
            lockSeat(show, seat, user);
        }
    }

    private void lockSeat(Show show, Seat seat, String user)  {
        if(!lockMap.containsKey(show)) {
            lockMap.put(show, new HashMap<>());
        }
//        Lock lock = new ReentrantLock();
//        lock.tryLock();
//        lock.unlock();

        SeatLock seatLock = new SeatLock(seat, show, user, new Date(), timeout);
        lockMap.get(show).put(seat, seatLock);
    }

    @Override
    synchronized public void unlockSeats(Show show, List<Seat> seats, String user) {
        for (Seat seat : seats) {
            if (validateLock(show, seat, user)) {
                unlockSeat(show, seat);
            }
        }
    }

    private void unlockSeat(Show show, Seat seat) {
        lockMap.get(show).remove(seat);
    }

    @Override
    public List<Seat> getLockedSeats(Show show) {
        return null;
    }

    @Override
    public boolean validateLock(Show show, Seat seat, String user) {
        return isSeatLocked(show, seat) && lockMap.get(show).get(seat).getUser().equals(user);
    }

    private boolean isSeatLocked(Show show, Seat seat) {
        return lockMap.containsKey(show) && lockMap.get(show).containsKey(seat)
                && !lockMap.get(show).get(seat).isLockExpired();
    }
}
