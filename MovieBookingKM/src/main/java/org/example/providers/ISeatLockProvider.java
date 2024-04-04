package org.example.providers;

public interface ISeatLockProvider {
    void lockSeats(); //show, seats, user

    void unlockSeats(); //show, seats, user

    boolean validateLock(); //show, seat, lock -> calls is lockexpired

    void getLockedSeats(); //
}
