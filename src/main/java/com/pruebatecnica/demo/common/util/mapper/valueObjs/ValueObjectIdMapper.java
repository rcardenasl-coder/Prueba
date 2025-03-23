package com.pruebatecnica.demo.common.util.mapper.valueObjs;

import com.pruebatecnica.demo.common.domain.valueobj.Id;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ValueObjectIdMapper {
    default Long map(Id id){
        return id!=null ? id.value() : null;
    }

    default Id map(Long id){
        return id != null ? new Id(id) : null;
    }
}
