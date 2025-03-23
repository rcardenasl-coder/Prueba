package com.pruebatecnica.demo.product.infraestructure.repository.sql;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductSqlRepository extends ReactiveCrudRepository<ProductData, Long> {
    Mono<Boolean> findByIdAndBranchId(Long id, Long branchId);
    @Query("""
        SELECT p.id AS id, p.name AS name, p.stock, b.id AS branch_id, b.name AS branch_name
        FROM (
            SELECT p.*,
                   ROW_NUMBER() OVER (PARTITION BY p.branch_id ORDER BY p.stock DESC) AS rn
            FROM product p
            JOIN branch b ON p.branch_id = b.id
            WHERE b.franchise_id = :franchiseId
              AND p.branch_id IS NOT NULL
        ) p
        JOIN branch b ON p.branch_id = b.id
        WHERE p.rn = 1
        """)
    Flux<ProductData> findTopStockProductsByFranchise(Long franchiseId);

    Flux<ProductData> findByBranchId(Long branchId);
}
