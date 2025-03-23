package com.pruebatecnica.demo.common.domain.valueobj;

import lombok.Getter;

public record Name(String value) {
    public Name {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("The name cannot be empty");
        }
    }
}
