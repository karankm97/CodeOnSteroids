package org.example.controller;

import lombok.NonNull;
import org.example.model.Buyer;
import org.example.model.LockerItem;
import org.example.model.Slot;
import org.example.service.LockerService;
import org.example.service.NotificationService;
import org.example.service.OtpService;

public class OrderController {
    private final OtpService otpService;
    private final NotificationService notificationService;
    private final LockerService lockerService;

    public OrderController(@NonNull final NotificationService notificationService,
                           @NonNull final OtpService otpService,
                           @NonNull final LockerService lockerService) {
        this.lockerService = lockerService;
        this.otpService = otpService;
        this.notificationService = notificationService;
    }

    public Slot allocateLocker(@NonNull final Buyer buyer, @NonNull final LockerItem lockerItem) {
        final Slot slot = lockerService.allocateSlot(lockerItem);
        final String otp = otpService.generateOtp(slot);
        notificationService.notifyUser(buyer, otp, slot);
        return slot;
    }
}
