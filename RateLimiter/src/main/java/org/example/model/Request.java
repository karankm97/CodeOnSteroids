package org.example.model;

public class Request {
    private final String requestId;
    private final long requestTime;

    public Request(final String requestId, final long requestTime) {
        this.requestId = requestId;
        this.requestTime = requestTime;
    }

    public String getRequestId() {
        return requestId;
    }

    public long getRequestTime() {
        return  requestTime;
    }
}
