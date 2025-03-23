package com.pruebatecnica.demo.product.infraestructure.controller;

import com.pruebatecnica.demo.product.application.port.in.ProductService;
import com.pruebatecnica.demo.product.infraestructure.controller.dto.ProductDTO;
import com.pruebatecnica.demo.product.infraestructure.controller.mappers.ProductDTOMapper;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/product")
@AllArgsConstructor
public class ProductController {
    private final ProductDTOMapper mapper;
    private final ProductService service;

    @PostMapping("/")
    public Mono<ProductDTO> create(@RequestBody ProductDTO productDTO){
        return service.create(mapper.toModel(productDTO)).map(mapper::toDTO);
    }

    @GetMapping("/search")
    public Mono<ProductDTO> getById(@RequestParam Long id){
        return service.findById(id).map(mapper::toDTO);
    }

    @PostMapping("/update")
    public Mono<ProductDTO> update(@RequestBody ProductDTO productDTO){
        return service.update(mapper.toModel(productDTO)).map(mapper::toDTO);
    }
}
