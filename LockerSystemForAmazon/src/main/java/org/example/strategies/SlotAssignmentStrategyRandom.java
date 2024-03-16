package org.example.strategies;

import lombok.NonNull;
import org.example.model.Slot;

import java.util.List;

public class SlotAssignmentStrategyRandom implements  ISlotAssignmentStrategy {
    private final IRandomGenerator randomGenerator;

    public SlotAssignmentStrategyRandom(@NonNull final IRandomGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    @Override
    public Slot pickSlot(@NonNull final List<Slot> slots) {
        if (slots.isEmpty()) {
            return null;
        }
        int slotNum = randomGenerator.getRandomNumber(slots.size());
        return slots.get(slotNum);
    }
}
