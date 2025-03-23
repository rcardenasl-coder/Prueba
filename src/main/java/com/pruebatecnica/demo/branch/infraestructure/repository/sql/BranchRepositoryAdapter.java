package com.pruebatecnica.demo.branch.infraestructure.repository.sql;

import com.pruebatecnica.demo.branch.domain.model.Branch;
import com.pruebatecnica.demo.branch.domain.ports.out.BranchPersistencePort;
import com.pruebatecnica.demo.branch.infraestructure.repository.sql.mappers.BranchDataMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Transactional
@RequiredArgsConstructor
public class BranchRepositoryAdapter implements BranchPersistencePort {

    private final BranchSqlRepository repository;
    private final BranchDataMapper mapper;

    @Override
    public Mono<Branch> saveOrUpdate(Branch branch) {
        return repository.save(mapper.toData(branch)).map(mapper::toModel);
    }

    @Override
    public Mono<Branch> findById(Long id) {
        return repository.findById(id).map(mapper::toModel);
    }

    @Override
    public Flux<Branch> findByFranchiseId(Long franchiseId) {
        return repository.findByFranchiseId(franchiseId)
                .map(mapper::toModel);
    }
}
