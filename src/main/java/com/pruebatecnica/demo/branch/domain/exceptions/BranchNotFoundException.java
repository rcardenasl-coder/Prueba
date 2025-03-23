package com.pruebatecnica.demo.branch.domain.exceptions;

public class BranchNotFoundException extends RuntimeException{
    public BranchNotFoundException(String message) {
        super(message);
    }
}
