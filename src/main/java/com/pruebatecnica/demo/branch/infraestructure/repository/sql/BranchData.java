package com.pruebatecnica.demo.branch.infraestructure.repository.sql;

import com.pruebatecnica.demo.product.infraestructure.repository.sql.ProductData;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Data;
import java.util.List;
import java.util.UUID;

@Data
@Table("branch")
public class BranchData {
    @Id
    private Long id;
    private String name;

    @Column("franchise_id")
    private Long franchiseId;

    @Transient
    private List<ProductData> products;
}
