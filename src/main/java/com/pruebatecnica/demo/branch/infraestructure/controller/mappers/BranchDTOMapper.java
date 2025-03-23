package com.pruebatecnica.demo.branch.infraestructure.controller.mappers;

import com.pruebatecnica.demo.branch.domain.model.Branch;
import com.pruebatecnica.demo.branch.infraestructure.controller.dto.BranchDTO;
import com.pruebatecnica.demo.common.util.mapper.valueObjs.ValueObjectIdMapper;
import com.pruebatecnica.demo.common.util.mapper.valueObjs.ValueObjectNameMapper;

import com.pruebatecnica.demo.product.infraestructure.controller.mappers.valueobjs.ValueObjectStockMapper;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring", uses = {ValueObjectNameMapper.class, ValueObjectIdMapper.class, ValueObjectStockMapper.class})
public interface BranchDTOMapper {
    BranchDTO toDTO(Branch branch);
    Branch toModel(BranchDTO branchDTO);
}