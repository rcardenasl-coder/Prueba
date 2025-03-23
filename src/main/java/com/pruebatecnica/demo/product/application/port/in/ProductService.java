package com.pruebatecnica.demo.product.application.port.in;

import com.pruebatecnica.demo.product.domain.model.Product;
import reactor.core.publisher.Mono;

public interface ProductService {
    Mono<Product> create(Product product);
    Mono<Product> update(Product product);
    Mono<Product> findById(Long id);
}
