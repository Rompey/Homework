package project_1.mapping;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import project_1.model.User;
import project_1.model.dto.UserCreateDTO;
import project_1.model.dto.UserDTO;



@Mapper
public interface UserMapper {
    UserMapper MAPPER = Mappers.getMapper(UserMapper.class);
    UserDTO map(User user);
    User map(UserDTO userDTO);

    UserCreateDTO createMapping(User user);

    User createMapping(UserCreateDTO userDTO);
}
