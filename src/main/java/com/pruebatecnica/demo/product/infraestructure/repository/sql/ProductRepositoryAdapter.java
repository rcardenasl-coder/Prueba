package com.pruebatecnica.demo.product.infraestructure.repository.sql;

import com.pruebatecnica.demo.product.domain.model.Product;
import com.pruebatecnica.demo.product.domain.ports.out.ProductPersistencePort;
import com.pruebatecnica.demo.product.infraestructure.repository.sql.mappers.ProductDataMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductRepositoryAdapter implements ProductPersistencePort {
    private final ProductSqlRepository repository;
    private final ProductDataMapper mapper;
    @Override
    public Mono<Product> saveOrUpdate(Product product) {
        return repository.save(mapper.toData(product)).map(mapper::toModel);
    }

    @Override
    public Mono<Product> findById(Long id) {
        return repository.findById(id).map(mapper::toModel);
    }

    @Override
    public Flux<Product> findTopStockProductsByFranchise(Long franchiseId) {
        return repository.findTopStockProductsByFranchise(franchiseId).map(mapper::toModel);
    }

    @Override
    public Flux<Product> findByBranchId(Long branchId) {
        return repository.findByBranchId(branchId).map(mapper::toModel);
    }

}
