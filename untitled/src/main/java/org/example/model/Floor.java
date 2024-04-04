package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class Floor {
    private final Integer floorNo;
    private final ExternalButton upButton;
    private final ExternalButton downButton;
    private final Building building;

    public Floor(final Integer floorNo, final ExternalButton upButton, final ExternalButton downButton, Building building) {
        this.floorNo = floorNo;
        this.upButton = upButton;
        this.downButton = downButton;
        this.building = building;
    }
}
