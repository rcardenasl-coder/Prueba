package com.pruebatecnica.demo.product.infraestructure.controller.mappers.valueobjs;

import com.pruebatecnica.demo.product.domain.model.valueobjects.Stock;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ValueObjectStockMapper {
    default Integer toDTO(Stock stock) {
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
