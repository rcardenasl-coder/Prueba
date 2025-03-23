package com.pruebatecnica.demo.product.application.service;

import com.pruebatecnica.demo.product.application.port.in.ProductService;
import com.pruebatecnica.demo.product.domain.model.Product;
import com.pruebatecnica.demo.product.domain.ports.in.ProductUseCasePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductUseCasePort useCase;
    @Override
    public Mono<Product> create(Product product) {
        return useCase.save(product);
    }

    @Override
    public Mono<Product> update(Product product) {
        return useCase.update(product);
    }

    @Override
    public Mono<Product> findById(Long id) {
        return useCase.findById(id);
    }
}
