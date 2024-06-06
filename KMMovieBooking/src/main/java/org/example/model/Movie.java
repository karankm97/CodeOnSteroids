package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Movie {
    private String id;
    private String name;
    private String genre;
    private Integer durationInSeconds;
}
