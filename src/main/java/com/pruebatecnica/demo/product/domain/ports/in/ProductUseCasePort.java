package com.pruebatecnica.demo.product.domain.ports.in;

import com.pruebatecnica.demo.product.domain.model.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductUseCasePort {
    Mono<Product> save(Product product);
    Mono<Product> update(Product product);
    Mono<Boolean> disassociateBranch(Long id);
    Flux<Product> findTopStockProductsByFranchise(Long franchiseID);
    Flux<Product> findAllByBranchId(Long branchId);
    Mono<Product> findById(Long id);
}
