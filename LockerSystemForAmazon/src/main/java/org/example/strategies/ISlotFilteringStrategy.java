package org.example.strategies;

import lombok.NonNull;
import org.example.model.LockerItem;
import org.example.model.Slot;

import java.util.List;

public interface ISlotFilteringStrategy {
    @NonNull
    List<Slot> filterSlots(@NonNull List<Slot> slots, @NonNull LockerItem lockerItem);
}
