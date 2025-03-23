package com.pruebatecnica.demo.branch.domain.model;

import com.pruebatecnica.demo.common.domain.valueobj.Id;
import com.pruebatecnica.demo.common.domain.valueobj.Name;
import com.pruebatecnica.demo.product.domain.model.Product;

import java.util.List;


public record Branch(Id id, Name name,Id franchiseId, List<Product> products) {
}
