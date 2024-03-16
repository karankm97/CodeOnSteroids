package org.example.strategies;

import lombok.NonNull;
import org.example.model.Slot;

import java.util.List;

public interface ISlotAssignmentStrategy {
    Slot pickSlot(@NonNull List<Slot> slots);
}
