package project_1.model.dto;

import java.util.Date;

public record TokenDTO(String token, Date expiredTime) {

}
