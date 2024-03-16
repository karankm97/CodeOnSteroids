package org.example.strategies;

import lombok.NonNull;

public interface IOtpGenerator {
    @NonNull
    String generateOtp();
}
