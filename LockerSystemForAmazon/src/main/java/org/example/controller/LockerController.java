package org.example.controller;

import lombok.NonNull;
import org.example.model.Locker;
import org.example.model.Size;
import org.example.model.Slot;
import org.example.service.LockerService;
import org.example.service.OtpService;

import java.util.List;
import java.util.concurrent.locks.Lock;

public class LockerController {
    private final LockerService lockerService;
    private final OtpService otpService;

    public LockerController(@NonNull final LockerService lockerService,
                            @NonNull final OtpService otpService) {
        this.lockerService = lockerService;
        this.otpService = otpService;
    }

    public Locker createLocker(@NonNull final String lockerId) {
        return lockerService.createLocker(lockerId);
    }

    public Slot createSlot(@NonNull final Locker locker, @NonNull final Size slotSize) {
        return lockerService.createSlot(locker, slotSize);
    }

    public List<Slot> getAvailableSlots() {
        return lockerService.getAllAvailableSlots();
    }

    public boolean unlockSlot(@NonNull final Slot slot, @NonNull final String otp) {
        return otpService.validateOtp(slot, otp);
    }

    public void deallocateSlot(@NonNull final Slot slot) {
        lockerService.deallocateSlot(slot);
    }
}
