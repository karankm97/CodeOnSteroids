package org.example.service;

import lombok.NonNull;
import org.example.model.Slot;
import org.example.repository.SlotOtpRepositoryInMemory;
import org.example.strategies.IOtpGenerator;

public class OtpService {
    private final IOtpGenerator otpGenerator;
    private final SlotOtpRepositoryInMemory slotRepository;

    public OtpService(IOtpGenerator otpGenerator, SlotOtpRepositoryInMemory slotRepository) {
        this.otpGenerator = otpGenerator;
        this.slotRepository = slotRepository;
    }

    @NonNull
    public String generateOtp(@NonNull final Slot slot) {
        final String otp = otpGenerator.generateOtp();
        slotRepository.addOtp(otp, slot.getSlotId());
        return  otp;
    }

    public boolean validateOtp(@NonNull final Slot slot, @NonNull final String otp) {
        final String savedOtp = slotRepository.getOtp(slot.getSlotId());
        return savedOtp != null && savedOtp.equals(otp);
    }
}
