package com.pruebatecnica.demo.product.infraestructure.config.beans;

import com.pruebatecnica.demo.product.domain.ports.in.ProductUseCasePort;
import com.pruebatecnica.demo.product.domain.ports.out.ProductPersistencePort;
import com.pruebatecnica.demo.product.domain.usecase.ProductUseCase;
import com.pruebatecnica.demo.product.infraestructure.repository.sql.ProductRepositoryAdapter;
import com.pruebatecnica.demo.product.infraestructure.repository.sql.ProductSqlRepository;
import com.pruebatecnica.demo.product.infraestructure.repository.sql.mappers.ProductDataMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class ProductConfig {
    private final ProductSqlRepository productSqlRepository;
    private final ProductDataMapper mapper;

    @Bean
    public ProductUseCasePort productUseCasePort(){
        return new ProductUseCase(persistencePort());
    }

    @Bean
    public ProductPersistencePort persistencePort(){
        return new ProductRepositoryAdapter(productSqlRepository,mapper);
    }

}
