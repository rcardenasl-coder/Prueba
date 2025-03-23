package com.pruebatecnica.demo.franchise.infraestructure.repository.sql;

import com.pruebatecnica.demo.franchise.domain.model.Franchise;
import com.pruebatecnica.demo.franchise.domain.ports.out.FranchisePersistencePort;
import com.pruebatecnica.demo.franchise.infraestructure.repository.sql.mappers.FranchiseDataMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@Service
@Transactional
@RequiredArgsConstructor
public class FranchiseRepositoryAdapter implements FranchisePersistencePort {

    private final FranchiseSqlRepository repository;
    private final FranchiseDataMapper mapper;

    @Override
    public Mono<Franchise> saveOrUpdate(Franchise franchise) {
        return repository.save(mapper.toData(franchise)).map(mapper::toModel);
    }

    @Override
    public Mono<Franchise> findById(Long id) {
        return repository.findById(id).map(mapper::toModel);
    }
}
