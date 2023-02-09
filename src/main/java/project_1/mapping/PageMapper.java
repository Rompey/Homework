package project_1.mapping;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import project_1.model.User;
import project_1.model.dto.UserDTO;

@Mapper
public interface PageMapper {

    PageMapper MAPPER = Mappers.getMapper(PageMapper.class);

    UserDTO createMapping(User user);

    default Page<UserDTO> createMapping(Page<User> users){
        return users.map(this::createMapping);
    }
}