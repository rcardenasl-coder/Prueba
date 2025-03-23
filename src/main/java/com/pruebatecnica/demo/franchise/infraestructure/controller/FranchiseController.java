package com.pruebatecnica.demo.franchise.infraestructure.controller;

import com.pruebatecnica.demo.franchise.application.port.in.FranchiseService;
import com.pruebatecnica.demo.franchise.infraestructure.controller.mappers.FranchiseDTOMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/franchise")
@RequiredArgsConstructor
public class FranchiseController {
    private final FranchiseService franchiseService;
    private final FranchiseDTOMapper mapper;

    @PostMapping("/")
    public Mono<FranchiseDTO> create(@RequestBody FranchiseDTO franchiseDTO){
        return franchiseService.create(mapper.toModel(franchiseDTO)).map(mapper::toDTO);
    }

    @PostMapping("/update")
    public Mono<FranchiseDTO> update(@RequestBody FranchiseDTO franchiseDTO){
        return franchiseService.update(mapper.toModel(franchiseDTO)).map(mapper::toDTO);
    }
    @GetMapping("/top-stock-products")
    public Mono<FranchiseDTO> findTopStockProductsByFranchise(Long id){
        return franchiseService.findTopStockProductsByFranchise(id).map(mapper::toDTO);
    }
}
