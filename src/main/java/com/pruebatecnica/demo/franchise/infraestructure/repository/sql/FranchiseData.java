package com.pruebatecnica.demo.franchise.infraestructure.repository.sql;

import com.pruebatecnica.demo.branch.infraestructure.repository.sql.BranchData;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Data;

import java.util.List;

@Data
@Table("franchise")
public class FranchiseData {
    @Id
    private Long id;
    private String name;

    @Transient
    private List<BranchData> branches;
}
