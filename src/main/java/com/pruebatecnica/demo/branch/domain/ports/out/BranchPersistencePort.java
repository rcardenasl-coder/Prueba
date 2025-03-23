package com.pruebatecnica.demo.branch.domain.ports.out;

import com.pruebatecnica.demo.branch.domain.model.Branch;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BranchPersistencePort {
    Mono<Branch> saveOrUpdate(Branch branch);
    Mono<Branch> findById(Long id);
    Flux<Branch> findByFranchiseId(Long franchiseId);
}
