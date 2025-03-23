package com.pruebatecnica.demo.franchise.domain.usecase;

import com.pruebatecnica.demo.branch.domain.model.Branch;
import com.pruebatecnica.demo.branch.domain.ports.in.BranchUseCasePort;
import com.pruebatecnica.demo.franchise.domain.model.Franchise;
import com.pruebatecnica.demo.franchise.domain.ports.in.FranchiseUseCasePort;
import com.pruebatecnica.demo.franchise.domain.ports.out.FranchisePersistencePort;

import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class FranchiseUseCase implements FranchiseUseCasePort {
    private static final Logger log = LogManager.getLogger(FranchiseUseCase.class);
    private final FranchisePersistencePort persistence;
    private final BranchUseCasePort branchUseCasePort;

    public FranchiseUseCase(FranchisePersistencePort persistence, BranchUseCasePort branchUseCasePort) {
        this.persistence = persistence;
        this.branchUseCasePort = branchUseCasePort;
    }

    @Override
    public Mono<Franchise> saveOrUpdate(Franchise franchise) {
        return persistence.saveOrUpdate(franchise);
    }

    @Override
    public Mono<Franchise> findTopStockProductsByFranchise(Long id) {
        if (id == null || id < 0) {
            return Mono.error(new IllegalArgumentException("Branch ID cannot be null"));
        }
        return buildFranchiseWithBranchs(id,branchUseCasePort.findTopStockProductsByFranchise(id));
    }

    @Override
    public Mono<Franchise> findById(Long id) {
        return persistence.findById(id);
    }

    private Mono<Franchise> buildFranchiseWithBranchs(Long idFranchise, Flux<Branch> branches){
        Mono<Franchise> franchiseMono = this.findById(idFranchise);
        Mono<List<Branch>> listMono = branches.collectList();
        return Mono.zip(franchiseMono, listMono)
                .map(tuple -> {
                    Franchise franchise = tuple.getT1();
                    List<Branch> branches1 = tuple.getT2();
                    return new Franchise(franchise.id(),franchise.name(),branches1);
                });
    }
}
