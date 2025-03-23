package com.pruebatecnica.demo.branch.infraestructure.repository.sql.mappers;

import com.pruebatecnica.demo.branch.domain.model.Branch;
import com.pruebatecnica.demo.branch.infraestructure.repository.sql.BranchData;
import com.pruebatecnica.demo.common.util.mapper.valueObjs.ValueObjectIdMapper;
import com.pruebatecnica.demo.common.util.mapper.valueObjs.ValueObjectNameMapper;
import com.pruebatecnica.demo.product.infraestructure.controller.mappers.valueobjs.ValueObjectStockMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",uses = {ValueObjectIdMapper.class, ValueObjectNameMapper.class, ValueObjectStockMapper.class})
public interface BranchDataMapper {
    BranchData toData(Branch branch);
    Branch toModel(BranchData branchData);
}
