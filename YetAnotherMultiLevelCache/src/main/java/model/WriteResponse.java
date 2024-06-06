package model;

import lombok.Getter;

@Getter
public class WriteResponse {
    Integer writeTime;

    public WriteResponse(Integer writeTime) {
        this.writeTime = writeTime;
    }
}
