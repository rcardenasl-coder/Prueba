package com.pruebatecnica.demo.branch.application.ports.in;

import com.pruebatecnica.demo.branch.domain.model.Branch;
import reactor.core.publisher.Mono;

public interface BranchService {
    Mono<Branch> create(Branch branch);
    Mono<Branch> update(Branch branch);
    Mono<Branch> disassociateProduct(Long id, Long productId);
    Mono<Branch> findById(Long id);
}
