package com.pruebatecnica.demo.franchise.infraestructure.controller.mappers;

import com.pruebatecnica.demo.common.domain.valueobj.Id;
import com.pruebatecnica.demo.common.domain.valueobj.Name;
import com.pruebatecnica.demo.franchise.domain.model.Franchise;
import com.pruebatecnica.demo.franchise.infraestructure.controller.FranchiseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface FranchiseDTOMapper {
    @Mapping(target = "id", source = "franchise.id.value")
    @Mapping(target = "name", source = "franchise.name.value")
    FranchiseDTO toDTO(Franchise franchise);

    @Mapping(target = "id", source = "franchiseDTO.id")
    @Mapping(target = "name", source = "franchiseDTO.name")
    @Mapping(target = "branches", ignore = true)
    Franchise toModel(FranchiseDTO franchiseDTO);

    default Long mapIdToLong(Id id) {
        if (id == null) {
            return null;
        }
        return id.value();
    }

    default Id mapLongToId(Long idValue) {
        if (idValue == null) {
            return null;
        }
        return new Id(idValue);
    }

    default String mapNameToString(Name name) {
        if (name == null) {
            return null;
        }
        return name.value();
    }

    default Name mapStringToName(String nameValue) {
        if (nameValue == null) {
            return null;
        }
        return new Name(nameValue);
    }
}