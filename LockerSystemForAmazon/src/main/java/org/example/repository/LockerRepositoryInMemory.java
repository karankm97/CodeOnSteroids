package org.example.repository;

import lombok.NonNull;
import org.example.exceptions.LockerAlreadyExistsException;
import org.example.model.Locker;
import org.example.model.Slot;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;

public class LockerRepositoryInMemory implements  ILockerRepository {
    private final List<Locker> allLockers;

    public LockerRepositoryInMemory() {
        this.allLockers = new ArrayList<>();
    }

    public Locker getLocker(@NonNull final String id) {
        for (Locker locker : this.allLockers) {
            if (locker.getAvailableSlots().equals(id)) {
                return locker;
            }
        }
        return null;
    }

    @NonNull
    public Locker createLocker(@NonNull final String id) {
        if(getLocker(id) != null) {
            throw new LockerAlreadyExistsException();
        }
        final Locker newLocker = new Locker(id);
        allLockers.add(newLocker);
        return newLocker;
    }

    @NonNull
    public List<Slot> getAllAvailableSlots() {
        final List<Slot> result = new ArrayList<>();
        for (Locker locker : allLockers) {
            result.addAll(locker.getAvailableSlots());
        }
        return result;
    }
}
