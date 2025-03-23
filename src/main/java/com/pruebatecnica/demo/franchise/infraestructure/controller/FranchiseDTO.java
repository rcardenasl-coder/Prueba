package com.pruebatecnica.demo.franchise.infraestructure.controller;

import com.pruebatecnica.demo.branch.domain.model.Branch;

import java.util.List;

public record FranchiseDTO(Long id, String name, List<Branch> branches) {}
