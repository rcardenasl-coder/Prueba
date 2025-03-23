package com.pruebatecnica.demo.product.infraestructure.controller.mappers;

import com.pruebatecnica.demo.common.util.mapper.valueObjs.ValueObjectIdMapper;
import com.pruebatecnica.demo.common.util.mapper.valueObjs.ValueObjectNameMapper;
import com.pruebatecnica.demo.product.domain.model.Product;
import com.pruebatecnica.demo.product.infraestructure.controller.dto.ProductDTO;
import com.pruebatecnica.demo.product.infraestructure.controller.mappers.valueobjs.ValueObjectStockMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {ValueObjectIdMapper.class, ValueObjectNameMapper.class, ValueObjectStockMapper.class})
public interface ProductDTOMapper {
    @Mapping(target = "id", source = "product.id.value")
    @Mapping(target = "name", source = "product.name.value")
    ProductDTO toDTO(Product product);
    Product toModel(ProductDTO productDTO);
}
