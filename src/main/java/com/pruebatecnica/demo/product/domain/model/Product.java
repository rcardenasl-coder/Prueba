package com.pruebatecnica.demo.product.domain.model;

import com.pruebatecnica.demo.product.domain.model.valueobjects.Stock;
import com.pruebatecnica.demo.common.domain.valueobj.Id;
import com.pruebatecnica.demo.common.domain.valueobj.Name;

public record Product(Id id, Name name, Stock stock, Long branchId) {
}
