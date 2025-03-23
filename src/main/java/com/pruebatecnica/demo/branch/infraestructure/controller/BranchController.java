package com.pruebatecnica.demo.branch.infraestructure.controller;

import com.pruebatecnica.demo.branch.application.ports.in.BranchService;
import com.pruebatecnica.demo.branch.infraestructure.controller.mappers.BranchDTOMapper;
import com.pruebatecnica.demo.branch.infraestructure.controller.dto.BranchDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/branch")
@AllArgsConstructor
public class BranchController {
    private final BranchService service;
    private final BranchDTOMapper branchDTOMapper;

    @GetMapping("/")
    public Mono<BranchDTO> getById(@RequestParam Long id){
        return service.findById(id).map(branchDTOMapper::toDTO);
    }

    @PostMapping("/")
    public Mono<BranchDTO> create(@RequestBody BranchDTO branchDTO){
        return service.create(branchDTOMapper.toModel(branchDTO)).map(branchDTOMapper::toDTO);
    }

    @PostMapping("/update")
    public Mono<BranchDTO> update(@RequestBody BranchDTO branchDTO){
        return service.update(branchDTOMapper.toModel(branchDTO)).map(branchDTOMapper::toDTO);
    }

    @GetMapping("/products/disassociate")
    public Mono<BranchDTO> disassociateProductFromBranch(@RequestParam Long branchId, @RequestParam Long productId){
        return service.disassociateProduct(branchId, productId).map(branchDTOMapper::toDTO);
    }
}
