package project1.mapping;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import project1.domain.Address;
import project1.dto.AddressDTO;

@Mapper
public interface AddressMapper {
    AddressMapper MAPPER = Mappers.getMapper(AddressMapper.class);

    AddressDTO map(Address address);

    Address map(AddressDTO addressDTO);
}
