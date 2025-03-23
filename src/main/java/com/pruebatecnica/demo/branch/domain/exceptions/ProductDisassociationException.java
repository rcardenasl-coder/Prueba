package com.pruebatecnica.demo.branch.domain.exceptions;

public class ProductDisassociationException extends RuntimeException{
    public ProductDisassociationException(String message) {
        super(message);
    }

    public ProductDisassociationException(String message, Throwable cause) {
        super(message,cause);
    }
}
