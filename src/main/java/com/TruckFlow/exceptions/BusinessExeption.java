package com.TruckFlow.exceptions;


public class BusinessExeption extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private final int errorCode = 400;

    public BusinessExeption(String message) {
        super(message);
    }

    public int getErrorCode() {
        return errorCode;
    }
}
