package com.pruebatecnica.demo.branch.infraestructure.controller.dto;

import com.pruebatecnica.demo.product.infraestructure.controller.dto.ProductDTO;

import java.util.List;

public record BranchDTO(Long id, String name, Long franchiseId, List<ProductDTO> products) {
}
