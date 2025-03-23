package com.pruebatecnica.demo.product.domain.model.valueobjects;

public record Stock(Integer value) {
    public Stock {
        if (value < 0) {
            throw new IllegalArgumentException("The stock cannot be negative");
        }
    }
}
