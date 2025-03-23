package com.pruebatecnica.demo.franchise.application.service;

import com.pruebatecnica.demo.franchise.application.port.in.FranchiseService;
import com.pruebatecnica.demo.franchise.domain.model.Franchise;
import com.pruebatecnica.demo.franchise.domain.ports.in.FranchiseUseCasePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class FranchiseServiceImpl implements FranchiseService {

    private final FranchiseUseCasePort useCase;

    @Override
    public Mono<Franchise> create(Franchise franchise) {
        return useCase.saveOrUpdate(franchise);
    }

    @Override
    public Mono<Franchise> update(Franchise franchise) {
        return useCase.saveOrUpdate(franchise);
    }

    @Override
    public Mono<Franchise> findTopStockProductsByFranchise(Long id) {
        return useCase.findTopStockProductsByFranchise(id);
    }
}
