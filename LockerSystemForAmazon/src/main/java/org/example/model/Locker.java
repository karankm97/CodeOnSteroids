package org.example.model;


import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Locker {
    private final String id;
    private final List<Slot> slots;

    public Locker(String id) {
        this.id = id;
        this.slots = new ArrayList<>();
    }

    public void addSlot(@NonNull final Slot newSlot) {
        this.slots.add(newSlot);
    }

    @NonNull //what does this mean
    public List<Slot> getAvailableSlots() {
        final List<Slot> result = new ArrayList<>();
        for(Slot slot : slots) {
            if(slot.isAvailable()) {
                result.add(slot);
            }
        }
        return result;
    }
}
