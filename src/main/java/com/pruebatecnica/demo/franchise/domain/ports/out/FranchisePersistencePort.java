package com.pruebatecnica.demo.franchise.domain.ports.out;

import com.pruebatecnica.demo.franchise.domain.model.Franchise;
import reactor.core.publisher.Mono;

public interface FranchisePersistencePort {
    Mono<Franchise> saveOrUpdate(Franchise franchise);
    Mono<Franchise> findById(Long id);
}
