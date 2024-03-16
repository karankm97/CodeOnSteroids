package org.example.model;

import lombok.NonNull;

public class Size {
    private final Double width;
    private final Double height;

    public Size(@NonNull final Double width, @NonNull final Double height) {
        this.width = width;
        this.height = height;
    }

    public boolean canAccommodate(@NonNull final Size sizeRequired) {
        return this.width >= sizeRequired.width && this.height >= sizeRequired.height;
    }
}
