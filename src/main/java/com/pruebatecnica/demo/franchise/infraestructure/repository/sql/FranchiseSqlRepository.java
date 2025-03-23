package com.pruebatecnica.demo.franchise.infraestructure.repository.sql;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface FranchiseSqlRepository extends ReactiveCrudRepository<FranchiseData, Long> {
}
