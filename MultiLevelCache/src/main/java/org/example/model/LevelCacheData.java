package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LevelCacheData {
    Integer readTime;
    Integer writeTime;
    //no capacity here - why?
}
