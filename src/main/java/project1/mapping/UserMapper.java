package project1.mapping;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import project1.domain.User;
import project1.dto.UserDTO;


@Mapper
public interface UserMapper {
    UserMapper MAPPER = Mappers.getMapper(UserMapper.class);
    UserDTO map(User user);
    User map(UserDTO userDTO);
}
