package com.TruckFlow.exceptions;

public class ErroResponse {

    private String message;
    private int errorCode;

    public ErroResponse(String message, int errorCode) {
        this.message = message;
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String ErrorResponse(String message, int errorCode) {
        this.message = message;
        this.errorCode = errorCode;
        return message;
    }

}
