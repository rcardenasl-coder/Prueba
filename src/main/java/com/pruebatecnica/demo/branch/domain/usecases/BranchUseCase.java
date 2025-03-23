package com.pruebatecnica.demo.branch.domain.usecases;

import com.pruebatecnica.demo.branch.domain.exceptions.BranchNotFoundException;
import com.pruebatecnica.demo.branch.domain.exceptions.ProductDisassociationException;
import com.pruebatecnica.demo.branch.domain.model.Branch;
import com.pruebatecnica.demo.branch.domain.ports.in.BranchUseCasePort;
import com.pruebatecnica.demo.branch.domain.ports.out.BranchPersistencePort;

import com.pruebatecnica.demo.product.domain.model.Product;
import com.pruebatecnica.demo.product.domain.ports.in.ProductUseCasePort;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;


public class BranchUseCase implements BranchUseCasePort {
    private static final Logger log = LogManager.getLogger(BranchUseCase.class);
    private final BranchPersistencePort persistencePort;
    private final ProductUseCasePort productUseCasePort;

    public BranchUseCase(BranchPersistencePort persistencePort, ProductUseCasePort productUseCasePort) {
        this.persistencePort = persistencePort;
        this.productUseCasePort = productUseCasePort;
    }

    @Override
    public Mono<Branch> saveOrUpdate(Branch branch) {
        return persistencePort.saveOrUpdate(branch);
    }

    @Override
    public Mono<Branch> findById(Long id) {
        if (id == null || id < 0) {
            return Mono.error(new IllegalArgumentException("Branch ID cannot be null or negative"));
        }

        Mono<Branch> branchMono = persistencePort.findById(id)
                .switchIfEmpty(Mono.error(new BranchNotFoundException("Branch with ID " + id + " not found")));

        Mono<List<Product>> productsMono = productUseCasePort.findAllByBranchId(id)
                .collectList();

        return Mono.zip(branchMono, productsMono)
                .map(tuple -> {
                    Branch branch = tuple.getT1();
                    List<Product> products = tuple.getT2();
                    return new Branch(branch.id(), branch.name(), branch.franchiseId(), products);
                });
    }

    @Override
    public Mono<Branch> disassociateProduct(Long id, Long productId) {
        if (id == null || productId == null) {
            return Mono.error(new IllegalArgumentException("Branch ID and Product ID cannot be null"));
        }

        return this.findById(id)
                .flatMap(branch -> productUseCasePort.disassociateBranch(productId)
                        .flatMap(success -> {
                            if (Boolean.TRUE.equals(success)) {
                                return Mono.just(branch);
                            } else {
                                return Mono.error(new ProductDisassociationException("Product with ID " + productId + " is already disassociated or cannot be disassociated"));
                            }
                        }))
                .onErrorResume(e -> Mono.error(new ProductDisassociationException("Failed to disassociate product with ID " + productId + " from branch with ID " + id, e)));
    }

    @Override
    public Flux<Branch> findTopStockProductsByFranchise(Long franchiseId) {
        if (franchiseId == null || franchiseId < 0) {
            return Flux.error(new IllegalArgumentException("Franchise ID cannot be null or negative"));
        }

        return persistencePort.findByFranchiseId(franchiseId)
                .switchIfEmpty(Mono.error(new BranchNotFoundException("No branches found for franchise with ID " + franchiseId)))
                .thenMany(
                        productUseCasePort.findTopStockProductsByFranchise(franchiseId)
                                .groupBy(Product::branchId)
                                .flatMap(groupedFlux -> {
                                    Long branchId = groupedFlux.key();
                                    return groupedFlux
                                            .collectList()
                                            .flatMap(products -> buildBranchWithProducts(branchId, products));
                                })
                );
    }

    private Mono<Branch> buildBranchWithProducts(Long idBranch, List<Product> products){
        return this.findById(idBranch).map(branch -> {
            return new Branch(branch.id(),branch.name(),branch.franchiseId(),products);
        });
    }

}
