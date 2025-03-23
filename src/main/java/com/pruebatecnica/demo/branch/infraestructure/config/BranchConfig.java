package com.pruebatecnica.demo.branch.infraestructure.config;

import com.pruebatecnica.demo.branch.domain.ports.in.BranchUseCasePort;
import com.pruebatecnica.demo.branch.domain.ports.out.BranchPersistencePort;
import com.pruebatecnica.demo.branch.domain.usecases.BranchUseCase;
import com.pruebatecnica.demo.branch.infraestructure.repository.sql.BranchRepositoryAdapter;
import com.pruebatecnica.demo.branch.infraestructure.repository.sql.BranchSqlRepository;
import com.pruebatecnica.demo.branch.infraestructure.repository.sql.mappers.BranchDataMapper;

import com.pruebatecnica.demo.product.domain.ports.in.ProductUseCasePort;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BranchConfig {
    private final BranchSqlRepository branchSqlRepository;
    private final BranchDataMapper branchDataMapper;
    private final ProductUseCasePort productUseCasePort;

    @Bean
    public BranchUseCasePort branchUseCasePort(){
        return new BranchUseCase(branchPersistencePort(),productUseCasePort);
    }

    @Bean
    public BranchPersistencePort branchPersistencePort(){
        return new BranchRepositoryAdapter(branchSqlRepository,branchDataMapper);
    }
}
