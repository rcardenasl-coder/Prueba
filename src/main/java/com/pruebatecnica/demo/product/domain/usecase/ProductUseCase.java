package com.pruebatecnica.demo.product.domain.usecase;

import com.pruebatecnica.demo.product.domain.exceptions.ProductNotFoundException;
import com.pruebatecnica.demo.product.domain.exceptions.ProductUpdateException;
import com.pruebatecnica.demo.product.domain.model.Product;
import com.pruebatecnica.demo.product.domain.ports.in.ProductUseCasePort;
import com.pruebatecnica.demo.product.domain.ports.out.ProductPersistencePort;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ProductUseCase implements ProductUseCasePort {
    private final ProductPersistencePort persistencePort;

    public ProductUseCase(ProductPersistencePort persistencePort) {
        this.persistencePort = persistencePort;
    }

    @Override
    public Mono<Product> save(Product product) {
        return persistencePort.saveOrUpdate(product);
    }

    @Override
    public Mono<Product> update(Product product){
        return persistencePort.saveOrUpdate(product);
    }

    @Override
    public Mono<Boolean> disassociateBranch(Long id) {
        if (id == null || id < 0) {
            return Mono.error(new IllegalArgumentException("Product ID cannot be null or negative"));
        }

        return persistencePort.findById(id)
                .switchIfEmpty(Mono.error(new ProductNotFoundException("Product with ID " + id + " not found")))
                .flatMap(product -> {
                    if (product.branchId() == null) {
                        return Mono.just(false);
                    }

                    Product newProduct = new Product(product.id(),product.name(),product.stock(),null);
                    return persistencePort.saveOrUpdate(newProduct)
                            .map(updatedProduct -> true)
                            .onErrorResume(e -> Mono.error(new ProductUpdateException("Failed to disassociate product with ID " + id, e)));
                });
    }

    @Override
    public Flux<Product> findTopStockProductsByFranchise(Long franchiseID) {
        return persistencePort.findTopStockProductsByFranchise(franchiseID);
    }

    @Override
    public Flux<Product> findAllByBranchId(Long branchId) {
        return persistencePort.findByBranchId(branchId);
    }

    @Override
    public Mono<Product> findById(Long id) {
        return persistencePort.findById(id);
    }
}
