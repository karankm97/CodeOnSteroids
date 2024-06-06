package model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class StatsResponse {
    Double avgReadTime;
    Double avgWriteTime;
    List<Double> usages;
}
