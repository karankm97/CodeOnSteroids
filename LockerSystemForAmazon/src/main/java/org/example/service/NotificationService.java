package org.example.service;

import lombok.NonNull;
import org.example.model.LockerUser;
import org.example.model.Slot;

public class NotificationService {
    public void notifyUser(@NonNull final LockerUser user, @NonNull final String otp, @NonNull final Slot slot) {
        System.out.println("Sending notification of otp: " + otp + " to: " + user + " for slot: " + slot);
    }
}
