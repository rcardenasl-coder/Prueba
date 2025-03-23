package com.pruebatecnica.demo.common.util.mapper.valueObjs;

import com.pruebatecnica.demo.common.domain.valueobj.Name;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ValueObjectNameMapper {
    default String map(Name name){
        return name != null ? name.value() : "";
    }

    default Name map(String name){
        return name != null ? new Name(name) : null;
    }
}
