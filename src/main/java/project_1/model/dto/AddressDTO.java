package project_1.model.dto;

public record AddressDTO(
        Integer id,
        String country,
        String city,
        String street,
        String home,
        Integer postIndex) {

}
