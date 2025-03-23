package com.pruebatecnica.demo.branch.domain.ports.in;

import com.pruebatecnica.demo.branch.domain.model.Branch;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BranchUseCasePort {
    Mono<Branch> saveOrUpdate(Branch branch);
    Mono<Branch> findById(Long id);
    Mono<Branch> disassociateProduct(Long id,Long productId);
    Flux<Branch> findTopStockProductsByFranchise(Long idFrancchise);
}
