package com.pruebatecnica.demo.branch.application.services;

import com.pruebatecnica.demo.branch.application.ports.in.BranchService;
import com.pruebatecnica.demo.branch.domain.model.Branch;
import com.pruebatecnica.demo.branch.domain.ports.in.BranchUseCasePort;
import com.pruebatecnica.demo.product.domain.ports.in.ProductUseCasePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class BranchServiceImpl implements BranchService {
    private final BranchUseCasePort useCase;
    private final ProductUseCasePort productUseCasePort;



    @Override
    public Mono<Branch> create(Branch branch) {
        return useCase.saveOrUpdate(branch);
    }

    @Override
    public Mono<Branch> update(Branch branch) {
        return useCase.saveOrUpdate(branch);
    }

    @Override
    public Mono<Branch> disassociateProduct(Long id, Long productId) {
        return useCase.disassociateProduct(id,productId);
    }

    @Override
    public Mono<Branch> findById(Long id) {
        return useCase.findById(id);
    }

}
