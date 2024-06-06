package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Instant;
import java.util.Date;

@AllArgsConstructor
@Getter
public class SeatLock {
    private Seat seat;
    private Show show;
    private String user;
    private Date lockTime;
    private Long timeout;

    public boolean isLockExpired() {
        Instant lockExpiry = lockTime.toInstant().plusSeconds(timeout);
        Instant currentInstant = new Date().toInstant();
        return lockExpiry.isBefore(currentInstant);
    }
}
