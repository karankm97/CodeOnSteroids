package utils;

import org.example.controller.LockerController;
import org.example.model.Locker;
import org.example.model.LockerItem;
import org.example.model.Size;
import org.example.model.Slot;
import org.example.model.Package;

import static utils.RandomUtils.randomString;

public class LockerUtils {
    public static Locker createTestLockerWithSlots(LockerController lockerController, Integer numSlots, Size slotSize) {
        final Locker locker = lockerController.createLocker(randomString());
        for (int i = 0; i < numSlots; i++) {
            final Slot slot1 = lockerController.createSlot(locker, slotSize);
        }
        return locker;
    }

    public static LockerItem randomLockerItem(Size itemSize) {
        return new Package (randomString(), itemSize);
    }
}
