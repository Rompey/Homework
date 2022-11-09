package project1.mapping;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import project1.domain.User;
import project1.dto.UserDTO;

@Mapper
public interface PageMapper {

    PageMapper MAPPER = Mappers.getMapper(PageMapper.class);

    UserDTO toRest(User user);

    default Page<UserDTO> toRest(Page<User> users) {
        return users.map(this::toRest);
    }

    UserDTO createMapping(User user);

    default Page<UserDTO> createMapping(Page<User> users){
        return users.map(this::createMapping);
    }
}