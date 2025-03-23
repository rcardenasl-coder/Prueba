package com.pruebatecnica.demo.franchise.domain.ports.in;

import com.pruebatecnica.demo.franchise.domain.model.Franchise;
import reactor.core.publisher.Mono;

public interface FranchiseUseCasePort {
    Mono<Franchise> saveOrUpdate(Franchise franchise);
    Mono<Franchise> findTopStockProductsByFranchise(Long id);
    Mono<Franchise> findById(Long id);
}
