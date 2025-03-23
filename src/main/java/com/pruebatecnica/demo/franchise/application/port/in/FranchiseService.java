package com.pruebatecnica.demo.franchise.application.port.in;

import com.pruebatecnica.demo.franchise.domain.model.Franchise;
import reactor.core.publisher.Mono;

public interface FranchiseService {
    Mono<Franchise> create(Franchise franchise);
    Mono<Franchise> update(Franchise franchise);
    Mono<Franchise> findTopStockProductsByFranchise(Long id);
}
