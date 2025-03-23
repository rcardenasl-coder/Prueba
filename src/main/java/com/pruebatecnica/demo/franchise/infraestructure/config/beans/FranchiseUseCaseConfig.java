package com.pruebatecnica.demo.franchise.infraestructure.config.beans;

import com.pruebatecnica.demo.branch.domain.ports.in.BranchUseCasePort;
import com.pruebatecnica.demo.franchise.domain.ports.in.FranchiseUseCasePort;
import com.pruebatecnica.demo.franchise.domain.ports.out.FranchisePersistencePort;
import com.pruebatecnica.demo.franchise.domain.usecase.FranchiseUseCase;
import com.pruebatecnica.demo.franchise.infraestructure.repository.sql.FranchiseRepositoryAdapter;
import com.pruebatecnica.demo.franchise.infraestructure.repository.sql.FranchiseSqlRepository;
import com.pruebatecnica.demo.franchise.infraestructure.repository.sql.mappers.FranchiseDataMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class FranchiseUseCaseConfig {
    private final FranchiseSqlRepository franchiseSqlRepository;
    private final FranchiseDataMapper franchiseDataMapper;
    private final BranchUseCasePort branchUseCasePort;

    @Bean
    public FranchiseUseCasePort franchiseUseCasePort(){
        return new FranchiseUseCase(franchisePersistencePort(), branchUseCasePort);
    }

    @Bean
    public FranchisePersistencePort franchisePersistencePort(){
        return new FranchiseRepositoryAdapter(franchiseSqlRepository,franchiseDataMapper);
    }
}
