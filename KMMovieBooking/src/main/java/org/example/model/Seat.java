package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class Seat {
    private String id;
    private Integer row;
    private Integer col;
}
