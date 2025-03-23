package com.pruebatecnica.demo.branch.infraestructure.repository.sql;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface BranchSqlRepository extends ReactiveCrudRepository<BranchData, Long> {
    Flux<BranchData> findByFranchiseId(Long franchiseId);
}
