package org.example.strategies;

import lombok.NonNull;
import org.example.model.LockerItem;
import org.example.model.Slot;

import java.util.List;
import java.util.stream.Collectors;

public class SlotFilteringStrategySizeBased implements  ISlotFilteringStrategy {
    @NonNull
    @Override
    public List<Slot> filterSlots(@NonNull final List<Slot> slots, @NonNull final LockerItem lockerItem) {
        return slots.stream()
                .filter(slot -> slot.getSize().canAccommodate(lockerItem.getSize()))
                .collect(Collectors.toList());
    }
}
