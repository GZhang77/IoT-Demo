package com.iot.sensor.payload;

public class Result {
    private Boolean request;
    private Object data;

    public Result(boolean request, Object data) {
        this.request = request;
        this.data = data;
    }

    public Boolean getRequest() {
        return request;
    }

    public void setRequest(Boolean request) {
        this.request = request;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }


}
