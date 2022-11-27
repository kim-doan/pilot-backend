package com.wdyj.boilerplate.exception;

public class SpotNotFoundException extends RuntimeException {
    public SpotNotFoundException(String msg, Throwable t) {
        super(msg, t);
    }

    public SpotNotFoundException(String msg) {
        super(msg);
    }

    public SpotNotFoundException() {
        super();
    }
}
