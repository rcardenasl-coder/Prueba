package com.pruebatecnica.demo.product.domain.ports.out;

import com.pruebatecnica.demo.product.domain.model.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductPersistencePort {
    Mono<Product> saveOrUpdate(Product product);
    Mono<Product> findById(Long id);
    Flux<Product> findTopStockProductsByFranchise(Long franchiseId);
    Flux<Product> findByBranchId(Long branchId);
}
