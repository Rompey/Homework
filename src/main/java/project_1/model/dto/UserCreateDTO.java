package project_1.model.dto;

public record UserCreateDTO(String username, String email, String password, AddressDTO address) {

}
