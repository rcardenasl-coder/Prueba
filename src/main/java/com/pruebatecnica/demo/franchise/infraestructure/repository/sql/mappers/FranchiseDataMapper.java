package com.pruebatecnica.demo.franchise.infraestructure.repository.sql.mappers;

import com.pruebatecnica.demo.common.util.mapper.valueObjs.ValueObjectNameMapper;
import com.pruebatecnica.demo.franchise.domain.model.Franchise;
import com.pruebatecnica.demo.franchise.infraestructure.repository.sql.FranchiseData;
import com.pruebatecnica.demo.common.util.mapper.valueObjs.ValueObjectIdMapper;
import com.pruebatecnica.demo.product.infraestructure.controller.mappers.valueobjs.ValueObjectStockMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ValueObjectIdMapper.class, ValueObjectNameMapper.class, ValueObjectStockMapper.class})
public interface FranchiseDataMapper {
    FranchiseData toData(Franchise franchise);
    Franchise toModel(FranchiseData franchiseData);
}
