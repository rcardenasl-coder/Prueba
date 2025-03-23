package com.pruebatecnica.demo.product.infraestructure.repository.sql.mappers;

import com.pruebatecnica.demo.common.util.mapper.valueObjs.ValueObjectIdMapper;
import com.pruebatecnica.demo.common.util.mapper.valueObjs.ValueObjectNameMapper;
import com.pruebatecnica.demo.product.domain.model.Product;
import com.pruebatecnica.demo.product.domain.model.valueobjects.Stock;
import com.pruebatecnica.demo.product.infraestructure.repository.sql.ProductData;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {ValueObjectIdMapper.class, ValueObjectNameMapper.class})
public interface ProductDataMapper {
    ProductData toData(Product product);
    Product toModel(ProductData productData);

    @Mapping(target = "stock", source = "product.stock", qualifiedByName = "mapStockToInteger")
    default Integer mapStockToInteger(Stock stock) {
        if (stock == null) {
            return null;
        }
        return stock.value();
    }
    default Stock toModel(Integer stockValue) {
        if (stockValue == null) {
            return null;
        }
        return new Stock(stockValue);
    }
}
