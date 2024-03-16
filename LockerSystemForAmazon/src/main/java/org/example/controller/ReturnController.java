package org.example.controller;

import lombok.NonNull;
import org.example.model.Buyer;
import org.example.model.DeliveryPerson;
import org.example.model.LockerItem;
import org.example.model.Slot;
import org.example.service.DeliveryPersonService;
import org.example.service.LockerService;
import org.example.service.NotificationService;
import org.example.service.OtpService;

public class ReturnController {
    private final NotificationService notificationService;
    private final OtpService otpService;
    private final LockerService lockerService;
    private  final DeliveryPersonService deliveryPersonService;

    public ReturnController(NotificationService notificationService, OtpService otpService,
                            LockerService lockerService, DeliveryPersonService deliveryPersonService) {
        this.notificationService = notificationService;
        this.deliveryPersonService = deliveryPersonService;
        this.otpService = otpService;
        this.lockerService = lockerService;
    }

    public void allocateLocker(@NonNull final Buyer buyer, @NonNull LockerItem lockerItem) {
        final Slot slot = lockerService.allocateSlot(lockerItem);
        final String otp = otpService.generateOtp(slot);
        final DeliveryPerson deliveryPerson = deliveryPersonService.getDeliveryPerson(slot);
        notificationService.notifyUser(deliveryPerson, otp, slot);
    }
}
