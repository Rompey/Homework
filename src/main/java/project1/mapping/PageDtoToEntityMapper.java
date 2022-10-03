package project1.mapping;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import project1.domain.User;
import project1.dto.UserDTO;

@Mapper
public interface PageDtoToEntityMapper {

    PageDtoToEntityMapper PAGE_DTO_TO_ENTITY_MAPPER = Mappers.getMapper(PageDtoToEntityMapper.class);
        UserDTO toRest(User entity);

        default Page<UserDTO> toRest(Page<User> page) {
            return page.map(this::toRest);
        }
    }