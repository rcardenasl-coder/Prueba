package com.pruebatecnica.demo.franchise.domain.model;

import com.pruebatecnica.demo.branch.domain.model.Branch;
import com.pruebatecnica.demo.common.domain.valueobj.Id;
import com.pruebatecnica.demo.common.domain.valueobj.Name;
import lombok.Builder;
import java.util.List;

@Builder(toBuilder = true)
public record Franchise (Id id, Name name, List<Branch> branches){}
