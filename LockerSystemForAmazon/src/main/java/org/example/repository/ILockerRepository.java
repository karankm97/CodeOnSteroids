package org.example.repository;

import lombok.NonNull;
import org.example.model.Locker;
import org.example.model.Slot;

import java.util.List;

public interface ILockerRepository {
    @NonNull
    Locker createLocker(@NonNull String id);

    @NonNull
    List<Slot> getAllAvailableSlots();
}
