package org.example.repository;

import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;

public class SlotOtpRepositoryInMemory implements ISlotOtpRepository {
    private final Map<String, String> slotIdToOtpMap;

    public SlotOtpRepositoryInMemory() {
        this.slotIdToOtpMap = new HashMap<>();
    }

    @Override
    public void addOtp(@NonNull final String otp, @NonNull final String slotId) {
        slotIdToOtpMap.put(slotId, otp);
    }

    @Override
    public String getOtp(@NonNull final String slotId) {
        return slotIdToOtpMap.get(slotId);
    }
}
