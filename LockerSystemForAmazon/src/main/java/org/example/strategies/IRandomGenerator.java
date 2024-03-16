package org.example.strategies;

import lombok.NonNull;

public interface IRandomGenerator {
    @NonNull
    Integer getRandomNumber(@NonNull Integer lessThanThis);
}
