package model;

import lombok.Getter;

@Getter
public class LevelCacheData {
    Integer readTime;
    Integer writeTime;

    public LevelCacheData(Integer readTime, Integer writeTime) {
        this.readTime = readTime;
        this.writeTime = writeTime;
    }
}
