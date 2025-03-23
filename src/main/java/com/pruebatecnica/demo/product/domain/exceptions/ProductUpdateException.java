package com.pruebatecnica.demo.product.domain.exceptions;

public class ProductUpdateException extends RuntimeException{
    public ProductUpdateException(String message, Throwable cause) {
        super(message, cause);
    }
}
