package com.preppy.jobpreparation.exception;

import org.springframework.http.HttpStatus;

public class InvalidInputException extends RuntimeException{
    private final int errorCode;
    public InvalidInputException(int errorCode, String message){
        super(message);
        this.errorCode = errorCode;
    }
    public InvalidInputException(Exception e){
        super(e.getLocalizedMessage());
        this.errorCode = HttpStatus.INTERNAL_SERVER_ERROR.value();
    }
    public  int getErrorCode() { return errorCode; }

    @Override
    public String toString(){
        return "Input Exception: errorCode=" + errorCode + ", message: "+getLocalizedMessage();
    }
}
