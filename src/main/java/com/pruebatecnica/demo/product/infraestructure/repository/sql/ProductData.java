package com.pruebatecnica.demo.product.infraestructure.repository.sql;

import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Data;
import java.util.UUID;

@Data
@Table("product")
@Builder(toBuilder = true)
public class ProductData {
    @Id
    private Long id;
    private String name;
    private Integer stock;

    @Column("branch_id")
    private Long branchId;
}
