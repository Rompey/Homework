package project_1.mapping;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import project_1.model.Address;
import project_1.model.dto.AddressDTO;

@Mapper
public interface AddressMapper {
    AddressMapper MAPPER = Mappers.getMapper(AddressMapper.class);

    AddressDTO map(Address address);

    Address map(AddressDTO addressDTO);
}
