package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@AllArgsConstructor
@Getter
public class Show {
    private String id;
    private Movie movie;
    private Screen screen;
    private Date startTime;
    private Integer durationInSeconds;
}
