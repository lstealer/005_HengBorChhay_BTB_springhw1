package com.hw1.springhw1.restcontroller.response;

public class ErrorResponse {

    private int code;
    private String details;

    public ErrorResponse() {

    }

    public ErrorResponse(int code, String details) {
        this.code = code;
        this.details = details;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "ErrorResponse{" +
                "code=" + code +
                ", details='" + details + '\'' +
                '}';
    }

}
